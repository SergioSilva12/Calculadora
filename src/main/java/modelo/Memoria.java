package modelo;

import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private static final Memoria instancia = new Memoria();
    private final List<MemoriaObservador> observadores = new ArrayList<>();
    private String textoAtual = "";

    private enum TipoComando{
        ZERAR,
        NUMERO,
        DIV,
        MULT,
        SOMA,
        IGUAL,
        VIRGULA,
        SUB
    };

    private Memoria(){

    }

    public static Memoria getInstancia(){
        return instancia;
    }

    public void adicionarObservador(MemoriaObservador o){
        observadores.add(o);
    }

    public String getTextoAtual(){
        return textoAtual.isEmpty()? "0" :textoAtual;
    }

    public void processarComando(String valor){

        TipoComando tipoComando = detectarTipoComando(valor);

        if(valor.equals("AC")){
            valor = "";
        }else{
            textoAtual +=valor;
        }
        observadores.forEach(o->o.valorAlterado(getTextoAtual()));
    }

    private TipoComando detectarTipoComando(String valor) {
        if(textoAtual.isEmpty() && textoAtual == "0"){
            return null;
        }

        try{
            Integer.parseInt(valor);
            return TipoComando.NUMERO;
        }catch (NumberFormatException e){
            //quando não for numero
            if("AC".equals(valor)){
                return TipoComando.ZERAR;
            }else if("/".equals(valor)){
                return TipoComando.DIV;
            }
            else if("*".equals(valor)){
                return TipoComando.MULT;
            }
            else if("+".equals(valor)){
                return TipoComando.SOMA;
            }
            else if("-".equals(valor)){
                return TipoComando.SUB;
            }
            else if("=".equals(valor)){
                return TipoComando.IGUAL;
            }else if(",".equals(valor)){
                return TipoComando.VIRGULA;
            }
        }

        return null;
    }
}
