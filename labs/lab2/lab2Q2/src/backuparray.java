public class backuparray
{
    public static void main(String[] args) {
        int [] numarray={5,10,15,20,25,30};
        int [] colearray=numarray.clone();
        System.out.println("orgnail array");
        for(int i=0;i<numarray.length;i++)
            System.out.println(numarray[i]+"  ");
            System.out.println();
            System.out.println("backup array");
            for(int i=0;i<colearray.length;i++)
                System.out.println(colearray[i]+"  ");
        System.out.println("\n");
        System.out.println("orgnail array == backup array");
        numarray=colearray;
        System.out.println(numarray==colearray);


    }
    }

