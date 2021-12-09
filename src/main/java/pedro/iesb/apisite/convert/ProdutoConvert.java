package pedro.iesb.apisite.convert;

import pedro.iesb.apisite.builder.ProdutoDTOBuilder;
import pedro.iesb.apisite.builder.ProdutoEntityBuilder;
import pedro.iesb.apisite.dto.ProdutoDto;
import pedro.iesb.apisite.model.entities.ProdutoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConvert {

    public ProdutoEntity getEntity(ProdutoDto prod){
        return new ProdutoEntityBuilder()
                .withName(prod.getName())
                .withDescription(prod.getDescription())
                .withPrice(prod.getPrice())
                .withQtd(prod.getQtd())
                .withSection(prod.getSection())
                .build();
    }

    public List<ProdutoDto> listDTO(List<ProdutoEntity> prods){

        List<ProdutoDto> prodDTOs = new ArrayList<>();

        for(ProdutoEntity p: prods){
            prodDTOs.add(getDTO(p));
        }

        return prodDTOs;
    }

    public ProdutoDto getDTO(ProdutoEntity prod){
        return new ProdutoDTOBuilder()
                .withName(prod.getName())
                .withQtd(prod.getQtd())
                .withSection(prod.getSection())
                .withPrice(prod.getPrice())
                .withDescription(prod.getDescription())
                .build();
    }
}
