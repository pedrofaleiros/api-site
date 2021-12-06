package pedro.iesb.apisite.convert;

import pedro.iesb.apisite.builder.ProdutoDTOBuilder;
import pedro.iesb.apisite.builder.ProdutoEntityBuilder;
import pedro.iesb.apisite.dto.ProdutoDTO;
import pedro.iesb.apisite.model.entities.ProdutoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConvert {

    public ProdutoEntity getEntity(ProdutoDTO prod){
        return new ProdutoEntityBuilder()
                .withName(prod.getName())
                .withDescription(prod.getDescription())
                .withPrice(prod.getPrice())
                .withQtd(prod.getQtd())
                .build();
    }

    public List<ProdutoDTO> listDTO(List<ProdutoEntity> prods){

        List<ProdutoDTO> prodDTOs = new ArrayList<>();

        for(ProdutoEntity p: prods){
            prodDTOs.add(new ProdutoDTOBuilder()
                    .withDescription(p.getDescription())
                    .withName(p.getName())
                    .withPrice(p.getPrice())
                    .withQtd(p.getQtd())
                    .build());
        }

        return prodDTOs;
    }
}
