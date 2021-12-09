package pedro.iesb.apisite.service.imp;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.convert.ProdutoConvert;
import pedro.iesb.apisite.dto.ProdutoDto;
import pedro.iesb.apisite.model.entities.ProdutoEntity;
import pedro.iesb.apisite.repository.ProdutoRepository;
import pedro.iesb.apisite.service.ProdutoServiceInterface;
import pedro.iesb.apisite.validation.ProdutoValidation;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService implements ProdutoServiceInterface {

    private final ProdutoRepository repository;
    private final ProdutoValidation validation;
    private final ProdutoConvert convert;

    public ProdutoService(ProdutoRepository repository){
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

        if(retorno == null){
            ProdutoEntity novo = convert.getEntity(prod);
            novo.setId(UUID.randomUUID().toString());
            repository.save(novo);
        }

        return retorno;
    }

    @Override
    public List<ProdutoDto> getProdutos(){
        return convert.listDTO(repository.get());
    }

    @Override
    public String atualizar(ProdutoDto prod, String name){
        String retorno = validation.verify(prod);

        if(name.equals("")){
            return "Nome invalido";
        }

        if(retorno == null){
            if(!repository.update(convert.getEntity(prod), name)){
                return "Produto nao encontrado";
            };
        }

        return retorno;
    }

    @Override
    public boolean deleta(ProdutoDto prod){

        return repository.delete(convert.getEntity(prod));
    }
}
