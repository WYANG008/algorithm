import math.Base36Addition;

public enum Others {

    Base36Addition("https://blog.nowcoder.net/n/4847a38e4b0f426c9c5b6c71ddf3880a", new Base36Addition()), // bytedance
    ;

    public String url;
    public Object obj;

    private Others(String url, Object obj) {
        this.url = url;
        this.obj = obj;
    }
}