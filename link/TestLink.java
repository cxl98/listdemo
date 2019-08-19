class Link{
    private Node root;
    private int count;
    private Object [] retDate;
    private int index=0;
    private class Node{
        private Object date;
        private Node next;

        public Node(Object date) {
            this.date = date;
        }

        public void addNode(Node newNode){
            if (this.next == null){
                this.next=newNode;
            }else{
                this.next.addNode(newNode);
            }

        }
        public void toArrayNode(){
            Link.this.retDate[Link.this.index++]=this.date;
            if (this.next!=null){
                this.next.toArrayNode();
            }
        }
        public  boolean containsNode(Object search) {
            if (search.equals(this.date)) {
                return true;
            }else {
                if (this.next == null) {
                    return this.next.containsNode(search);
                }else{
                    return false;
                }
            }

        }
        public Object getNode(int searchIndex){
            if (Link.this.index ++==searchIndex){
                return this.date;
            }else{
                return this.next.getNode(searchIndex);
            }
        }
        public void setNode(int searchIndex,Object newDate){
            if (Link.this.index++ == searchIndex){
                this.date=newDate;
            }else {
                if (this.next!=null){
                    this.next.setNode(searchIndex,newDate);
                }
            }
        }
        public void removeNode(Node p,Object date){
            if (this.date.equals(date)){
                p.next=this.next;
            }else {
                this.next.removeNode(this,date);
            }
        }

    }
    public void add(Object date){
        if (date==null){
            return;
        }
        Node newNode=new Node(date);
        if (this.root==null){
            this.root=newNode;
        }else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
    public boolean isEmpty(){
        if (this.root==null&&this.count==0){
            return false;
        }else {
            return true;
        }
    }
    public Object toArray(){
        if (this.count==0){
            return null;
        }
        this.retDate=new Object[this.count];
        this.index=0;
        this.root.toArrayNode();
        return this.retDate;
    }
    public boolean contains(Object search){
        if (search==null||this.root==null){
            return false;
        }
        return this.root.containsNode(search);
    }
    public Object get(int searchIndex){
        if (searchIndex>=this.count){
            return null;
        }
        this.index=0;
        return this.root.getNode(searchIndex);
    }
    public void setDate(int searchIndex, Object date){
        if (searchIndex>=this.count){
            return ;
        }else {
            this.index=0;
            this.root.setNode(searchIndex,date);
        }

    }
    public void removeDate(Object date){
        if (this.contains(date)){
            if (this.root.date.equals(date)){
                this.root=this.root.next;
            }else{
            this.root.next.removeNode(this.root,date);
        }
        this.count--;
        }
    }
}
class Factory {
    public static Link getInstance() {
        return new Link();
    }
}


public class TestLink {
    public static void main(String[] args) {
        Link aa=Factory.getInstance();
        aa.add("AAA");
        aa.add("BBB");
        aa.add("CCC");
        System.out.println("长度为"+aa.getCount());
        System.out.println("  "+aa.get(1));
        aa.setDate(1,"aaa");
        System.out.println("aaaa  " +aa.getCount());
        aa.removeDate("AAA");
        System.out.println("长度"+aa.getCount());
    }
}
