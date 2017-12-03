package ch.ibw.visitor;

import ch.ibw.AttributedCompositeNode;
import ch.ibw.CommentNode;
import ch.ibw.HtmlNode;

public class CommentRatioCompositeVisitor implements CompositeVisitor {

  private Double nrOfComments = 0.0;
  private Double nrOfNoneComments = 0.0;

  @Override
  public void visit(CommentNode node) {
    ++nrOfComments;
  }

  @Override
  public void visit(HtmlNode node) {
    ++nrOfNoneComments;
  }

  @Override
  public void visit(AttributedCompositeNode attributedCompositeNode) {

  }

  public Double getPercentageOfComments(){
    double totalNrOfNodes = nrOfNoneComments + nrOfComments;
    return nrOfComments / (totalNrOfNodes /100);
  }
}
