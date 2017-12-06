package ch.ibw.visitor;

import ch.ibw.AttributedCompositeNode;
import ch.ibw.CommentNode;
import ch.ibw.HtmlNode;

import java.util.HashSet;
import java.util.Set;

public class EnsureUniqueIdVisitor implements CompositeVisitor {

  Set<Object> ids = new HashSet<>();
  private static final String ID_ATTRIBUTE_NAME = "id";

  @Override
  public void visit(CommentNode node) {

  }

  @Override
  public void visit(HtmlNode node) {
    removeIfDuplicateId(node);
  }

  private void removeIfDuplicateId(AttributedCompositeNode node) {
    Object idValue = node.attributes.get(ID_ATTRIBUTE_NAME);
    if(ids.contains(idValue)){
      node.attributes.remove(ID_ATTRIBUTE_NAME);
    }else{
      ids.add(idValue);
    }
  }

  @Override
  public void visit(AttributedCompositeNode attributedCompositeNode) {
    removeIfDuplicateId(attributedCompositeNode);
  }
}
