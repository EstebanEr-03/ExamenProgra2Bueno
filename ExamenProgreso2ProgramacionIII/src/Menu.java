import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Menu {
    List<Plato> platosMenu=new ArrayList<>();
    List<Plato> arregloBurbuja=new ArrayList<>();
    List<Plato> arregloInsercion=new ArrayList<>();


    public Menu() {
    }

    public void addPlatos(Plato plato1){
        platosMenu.add(plato1);
        Collections.sort(platosMenu);
    }
    public void removePackage(List<Plato> listaRemover,String trackingNumberT){
        if (searchByTrackingNameLineal(listaRemover,trackingNumberT)>=0){
            platosMenu.remove(searchByTrackingNameLineal(listaRemover,trackingNumberT));
        }
    }
    public int searchByTrackingNameLineal(List<Plato> listaBuscar, String nombrePlato) {
        for (int j=0; j<listaBuscar.size(); j++){
            if (listaBuscar!= null && listaBuscar.size()>=0 && listaBuscar.get(j).getNombrePlato().equals(nombrePlato)){
                return j;
            }
        }
        return -1;
    }
    public  Plato searchBinary(List<Plato> listaBuscarPorTrackingBinario, String targetTrackingNameT) {
        int izquierda=0, derecha= listaBuscarPorTrackingBinario.size() -1;
        while (izquierda<=derecha){
            int numMedio=(derecha+izquierda)/2;
            if(targetTrackingNameT.equals(listaBuscarPorTrackingBinario.get(numMedio).nombrePlato)){
                return listaBuscarPorTrackingBinario.get(numMedio);
            }else if(listaBuscarPorTrackingBinario.get(numMedio).getNombrePlato().compareTo(targetTrackingNameT) < 0){
                izquierda=numMedio+1;
            }else{
                derecha=numMedio-1;
            }
        }
        return null;
    }
    public void Burbuja(){
        arregloBurbuja = new ArrayList<>();
        for (Plato packagesRetornar:platosMenu){
            try {
                Plato packageAux=packagesRetornar.deepClone();
                arregloBurbuja.add(packageAux);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        int n = arregloBurbuja.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arregloBurbuja.get(j).getNombrePlato().compareTo(arregloBurbuja.get(j+1).getNombrePlato()) >0 ) {
                    String temp = arregloBurbuja.get(j).getNombrePlato();
                    arregloBurbuja.get(j).setNombrePlato(arregloBurbuja.get(j+1).getNombrePlato()) ;
                    arregloBurbuja.get(j+1).setNombrePlato(temp);
                }
            }
        }
    }

    public List<Plato> getArregloBurbuja() {
        return arregloBurbuja;
    }

    public void Insercion(){
        arregloInsercion = new ArrayList<>();
        for (Plato packagesRetornar:platosMenu){
            try {
                Plato packageAux=packagesRetornar.deepClone();
                arregloInsercion.add(packageAux);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        int n = arregloInsercion.size();
        for (int i = 1; i < n; ++i) {
            String key = arregloInsercion.get(i).getNombrePlato();
            int j = i - 1;

            while (j >= 0 && arregloInsercion.get(j).getNombrePlato().compareTo(key) > 0) {
                arregloInsercion.get(j+1).setNombrePlato(arregloInsercion.get(j).getNombrePlato());
                j = j - 1;
            }
            arregloInsercion.get(j+1).setNombrePlato(key) ;
        }
    }

    public List<Plato> getArregloInsercion() {
        return arregloInsercion;
    }

}
