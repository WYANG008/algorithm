import stackAndQueue.QueueUsing2Stacks;

public enum GeeksForGeeksProblems {
    QueueUsing2Stacks("https://www.geeksforgeeks.org/queue-using-stacks/", new QueueUsing2Stacks()),
    ;

    public String url;
    public Object obj;

    private GeeksForGeeksProblems(String url, Object obj) {
        this.url = url;
        this.obj = obj;
    }
}
