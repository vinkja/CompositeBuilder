package ch.ibw.visitor;

import ch.ibw.AttributedCompositeNode;
import ch.ibw.CommentNode;
import ch.ibw.HtmlNode;

public interface CompositeVisitor {

  void visit(CommentNode node);

  void visit(HtmlNode node);

  void visit(AttributedCompositeNode attributedCompositeNode);

  default void acceptAll(AttributedCompositeNode node){
    node.accept(this);
    node.children.stream().forEach(child -> acceptAll(child));
  }
}
