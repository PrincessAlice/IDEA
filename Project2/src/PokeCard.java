import java.util.Objects;

//定义一个类
public class PokeCard {
    private String colors;
    private int val;

    public PokeCard(String colors, int val) {
        this.colors = colors;
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("[%d,%s]",val,colors);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        //返回obj对象能否被PokeCard 类型的引用指向
        //obj对象的类型是不是PokeCard类型的小类型
        if(!(obj instanceof PokeCard)){
            return false;
        }
        PokeCard other = (PokeCard)obj;
        return this.val == other.val && this.colors.equals(other.colors);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokeCard pokeCard = (PokeCard) o;
        return val == pokeCard.val &&
                Objects.equals(colors, pokeCard.colors);
    }
    */

}

