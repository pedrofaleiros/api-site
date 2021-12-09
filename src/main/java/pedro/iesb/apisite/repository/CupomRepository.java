package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.dto.Cupom;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CupomRepository {

    private final List<Cupom> cupons = new ArrayList<>();

    public CupomRepository() {
        for(int i = 5; i <= 25; i+=5){
            float desconto = (float) i / 100;
            cupons.add(new Cupom("BLACKFRIDAY"+Integer.toString(i), desconto));
        }
    }

    public List<Cupom> get(){
        return cupons;
    }

}
