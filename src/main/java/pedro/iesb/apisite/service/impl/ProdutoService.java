package pedro.iesb.apisite.service.impl;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.convert.ProdutoConvert;
import pedro.iesb.apisite.dto.ProdutoDto;
import pedro.iesb.apisite.model.entities.ProdutoEntity;
import pedro.iesb.apisite.repository.ProdutoRepositoryInterface;
import pedro.iesb.apisite.service.ProdutoServiceInterface;
import pedro.iesb.apisite.validation.ProdutoValidation;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService implements ProdutoServiceInterface {

    private final ProdutoRepositoryInterface repository;
    private final ProdutoValidation validation;
    private final ProdutoConvert convert;

    public ProdutoService(ProdutoRepositoryInterface repository){
        this.repository = repository;
        this.validation = new ProdutoValidation();
        this.convert = new ProdutoConvert();
    }

    @Override
    public String cadastrar(ProdutoDto prod){

        String retorno = validation.verify(prod);

        if(repository.findByName(prod.getName())){
            retorno = "Produto ja existe";
        }

        if(retorno != null){
            return retorno;
        }

        ProdutoEntity novo = convert.getEntity(prod);
        novo.setId(UUID.randomUUID().toString());
        repository.save(novo);
        return null;
    }

    @Override
    public List<ProdutoDto> getProdutos(){
        return convert.listDTO(repository.get());
    }

    @Override
    public String atualizar(ProdutoDto prod, String name){

        if (name == null || name.equals("")){
            return "Insira o nome do produto";
        }

        String retorno = validation.verify(prod);

        if(retorno != null){
            return retorno;
        }

        if(!repository.findByName(name)){
            return "Produto nao encontrado";
        }

        repository.update(convert.getEntity(prod), name);

        return null;
    }

    @Override
    public boolean deleta(String name){

        ProdutoEntity p = repository.getByName(name);

        if(p != null){
            if(p.getSold() == 0){
                repository.delete(p);
                return true;
            }
        }

        return false;
    }
}
