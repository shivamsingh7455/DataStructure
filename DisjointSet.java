
import java.util.*;
class DisjointSet
{
    private int parent[];
    private int size[];
    DisjointSet(int size)
    {
        this.size=new int[size+1];
        parent=new int [size+1];
        
    }
    
    
    public void makeSet(int i)
    {
        parent[i]=i;
        size[i]=1;
    }
    public int findSet(int  i)
        {
            if(parent[i]==i)
                return i;
            else 
            {
            parent[i]=findSet(parent[i]);
            return parent[i];
            }
        }
    
    public boolean union(int i,int j)
    {
        int x=findSet(i);
        int y=findSet(j);
        if(x!=y)
        {
            if(size[y]>=size[x])
            {
            parent[x]=y;
            size[y]+=size[x];
            }
            
            else
            {
            parent[y]=x;
            size[x]+=size[y];
            }
            return true;
        }
        else    
            return false;
    }
    public int getSize(int i)
    {
        return size[findSet(i)];
    }
    @Override
    public String toString()
    {
        return "{\n"+Arrays.toString(parent)+"\n"
        +Arrays.toString(size)+"\n}";
        
    }
}
