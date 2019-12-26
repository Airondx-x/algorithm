public class draft extends parent{

    draft(int a) {
        super(a);
    }

    public static void main(String[] args) {
        parent p = new parent(1);
        draft a = (draft)p;
        System.out.println(a.a);


        draft[] d = new draft[10];
        d[0] = new draft(1);
        parent b = d[0];
    }
}


class parent{

    parent(int a){
        this.a = a;
    }
    int a = 1;
        }