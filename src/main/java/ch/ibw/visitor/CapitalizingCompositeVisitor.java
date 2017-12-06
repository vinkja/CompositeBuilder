package ch.ibw.visitor;

import ch.ibw.AttributedCompositeNode;
import ch.ibw.CommentNode;
import ch.ibw.HtmlNode;

public class CapitalizingCompositeVisitor implements CompositeVisitor {

  @Override
  public void visit(CommentNode node) {

  }

  @Override
  public void visit(HtmlNode node) {
    node.name = node.name.toUpperCase();
  }

  @Override
  public void visit(AttributedCompositeNode attributedCompositeNode) {

  }
}
