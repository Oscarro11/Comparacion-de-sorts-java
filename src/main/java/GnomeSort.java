public class GnomeSort <T extends Comparable<T> > implements  Isort<T>{
    public list <T> ordenar(List<T> estructura) {
        int index =0;
        while (index < estructura.length(){
            if (index ==0){
                index++;
            }
            else if (estructura[index] >= estructura[index -1]){
                index++;
            } 
            else {
                int temp = estructura[index];
                estructura[index] = estructura[index -1];
                estructura[index -1] = temp;
                index--;
            }
                
        }
    } return estructura;
        
}