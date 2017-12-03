package ch.ibw;

public class CommentNode extends AttributedCompositeNode {
  public String comment;

  private CommentNode(String comment) {
    super();
    this.comment = comment;
  }

  @Override
  public CommentNode setAttribute(String key, String value) {
    return this;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

  public static CommentNode create(String comment){
    return new CommentNode(comment);
  }
}
