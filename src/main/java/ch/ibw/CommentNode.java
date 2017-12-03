package ch.ibw;

import ch.ibw.visitor.CompositeVisitor;

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
  public void accept(CompositeVisitor visitor) {
    visitor.visit(this);
  }

  public static CommentNode create(String comment){
    return new CommentNode(comment);
  }
}
