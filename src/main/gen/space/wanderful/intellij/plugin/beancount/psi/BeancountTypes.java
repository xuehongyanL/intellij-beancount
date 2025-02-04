// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountElementTypeFactory;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountElementType;
import space.wanderful.intellij.plugin.beancount.psi.impl.*;

public interface BeancountTypes {

  IElementType ACCOUNT = BeancountElementTypeFactory.factoryAccount("ACCOUNT");
  IElementType ACCOUNT_DELIMITER = new BeancountElementType("ACCOUNT_DELIMITER");
  IElementType ACCOUNT_NAME = new BeancountElementType("ACCOUNT_NAME");
  IElementType ACCOUNT_SEGMENT = new BeancountElementType("ACCOUNT_SEGMENT");
  IElementType AMOUNT = new BeancountElementType("AMOUNT");
  IElementType BALANCE_DIR = new BeancountElementType("BALANCE_DIR");
  IElementType COMMODITY_DIR = new BeancountElementType("COMMODITY_DIR");
  IElementType COMPOUND_AMOUNT = new BeancountElementType("COMPOUND_AMOUNT");
  IElementType COST_COMP = new BeancountElementType("COST_COMP");
  IElementType COST_COMP_LIST = new BeancountElementType("COST_COMP_LIST");
  IElementType COST_SPEC = new BeancountElementType("COST_SPEC");
  IElementType CURRENCY_SYMBOL = BeancountElementTypeFactory.factoryCurrency("CURRENCY_SYMBOL");
  IElementType CUSTOM_DIR = new BeancountElementType("CUSTOM_DIR");
  IElementType DIRECTIVE = new BeancountElementType("DIRECTIVE");
  IElementType DIV_EXPR = new BeancountElementType("DIV_EXPR");
  IElementType DOCUMENT_DIR = new BeancountElementType("DOCUMENT_DIR");
  IElementType EVENT_DIR = new BeancountElementType("EVENT_DIR");
  IElementType EXPR = new BeancountElementType("EXPR");
  IElementType INCLUDE_DIR = new BeancountElementType("INCLUDE_DIR");
  IElementType KEY_VALUE = new BeancountElementType("KEY_VALUE");
  IElementType KEY_VALUE_VALUE = new BeancountElementType("KEY_VALUE_VALUE");
  IElementType LINK_VALUE = new BeancountElementType("LINK_VALUE");
  IElementType LITERAL_EXPR = new BeancountElementType("LITERAL_EXPR");
  IElementType MINUS_EXPR = new BeancountElementType("MINUS_EXPR");
  IElementType MUL_EXPR = new BeancountElementType("MUL_EXPR");
  IElementType NOTE_DIR = new BeancountElementType("NOTE_DIR");
  IElementType OPEN_DIR = new BeancountElementType("OPEN_DIR");
  IElementType OPTION_DIR = new BeancountElementType("OPTION_DIR");
  IElementType PAD_DIR = new BeancountElementType("PAD_DIR");
  IElementType PAREN_EXPR = new BeancountElementType("PAREN_EXPR");
  IElementType PLUGIN_DIR = new BeancountElementType("PLUGIN_DIR");
  IElementType PLUS_EXPR = new BeancountElementType("PLUS_EXPR");
  IElementType POSTING_LINE = new BeancountElementType("POSTING_LINE");
  IElementType POSTING_LIST = new BeancountElementType("POSTING_LIST");
  IElementType POSTING_PRICE = new BeancountElementType("POSTING_PRICE");
  IElementType PRICE_DIR = new BeancountElementType("PRICE_DIR");
  IElementType QUERY_DIR = new BeancountElementType("QUERY_DIR");
  IElementType TAG_LINK = new BeancountElementType("TAG_LINK");
  IElementType TAG_VALUE = new BeancountElementType("TAG_VALUE");
  IElementType TRANSACTION_DIR = new BeancountElementType("TRANSACTION_DIR");
  IElementType UNARY_MIN_EXPR = new BeancountElementType("UNARY_MIN_EXPR");
  IElementType UNARY_PLUS_EXPR = new BeancountElementType("UNARY_PLUS_EXPR");

  IElementType ACCOUNT_WORD = new BeancountTokenType("ACCOUNT_WORD");
  IElementType ASTERISK = new BeancountTokenType("ASTERISK");
  IElementType AT = new BeancountTokenType("AT");
  IElementType ATAT = new BeancountTokenType("ATAT");
  IElementType BALANCE = new BeancountTokenType("BALANCE");
  IElementType BOOL = new BeancountTokenType("bool");
  IElementType BOOLEAN = new BeancountTokenType("BOOLEAN");
  IElementType CARET = new BeancountTokenType("CARET");
  IElementType COLON = new BeancountTokenType("COLON");
  IElementType COMMA = new BeancountTokenType("COMMA");
  IElementType COMMENT = new BeancountTokenType("comment");
  IElementType COMMODITY = new BeancountTokenType("COMMODITY");
  IElementType CURRENCY = new BeancountTokenType("CURRENCY");
  IElementType CUSTOM = new BeancountTokenType("CUSTOM");
  IElementType DATE = new BeancountTokenType("DATE");
  IElementType DIVIDE = new BeancountTokenType("DIVIDE");
  IElementType DOCUMENT = new BeancountTokenType("DOCUMENT");
  IElementType EMPTY = new BeancountTokenType("empty");
  IElementType EOL = new BeancountTokenType("eol");
  IElementType EVENT = new BeancountTokenType("EVENT");
  IElementType FLAG = new BeancountTokenType("FLAG");
  IElementType HASH = new BeancountTokenType("HASH");
  IElementType INCLUDE = new BeancountTokenType("INCLUDE");
  IElementType INDENT = new BeancountTokenType("INDENT");
  IElementType LCURL = new BeancountTokenType("LCURL");
  IElementType LCURLCURL = new BeancountTokenType("LCURLCURL");
  IElementType LPAREN = new BeancountTokenType("LPAREN");
  IElementType META_KEY = new BeancountTokenType("META_KEY");
  IElementType META_KV_DELIMITER = new BeancountTokenType("META_KV_DELIMITER");
  IElementType MINUS = new BeancountTokenType("MINUS");
  IElementType NEGATIVE_NUMBER = new BeancountTokenType("NEGATIVE_NUMBER");
  IElementType NOTE = new BeancountTokenType("NOTE");
  IElementType NUMBER = new BeancountTokenType("NUMBER");
  IElementType OPEN = new BeancountTokenType("OPEN");
  IElementType OPTION = new BeancountTokenType("OPTION");
  IElementType PAD = new BeancountTokenType("PAD");
  IElementType PLUGIN = new BeancountTokenType("PLUGIN");
  IElementType PLUS = new BeancountTokenType("PLUS");
  IElementType PRICE = new BeancountTokenType("PRICE");
  IElementType QUERY = new BeancountTokenType("QUERY");
  IElementType RCURL = new BeancountTokenType("RCURL");
  IElementType RCURLCURL = new BeancountTokenType("RCURLCURL");
  IElementType RPAREN = new BeancountTokenType("RPAREN");
  IElementType SKIP = new BeancountTokenType("skip");
  IElementType STRING = new BeancountTokenType("STRING");
  IElementType TAG = new BeancountTokenType("tag");
  IElementType TAG_LINK_VALUE = new BeancountTokenType("TAG_LINK_VALUE");
  IElementType TXN = new BeancountTokenType("TXN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACCOUNT) {
        return new BeancountAccountImpl(node);
      }
      else if (type == ACCOUNT_DELIMITER) {
        return new BeancountAccountDelimiterImpl(node);
      }
      else if (type == ACCOUNT_NAME) {
        return new BeancountAccountNameImpl(node);
      }
      else if (type == ACCOUNT_SEGMENT) {
        return new BeancountAccountSegmentImpl(node);
      }
      else if (type == AMOUNT) {
        return new BeancountAmountImpl(node);
      }
      else if (type == BALANCE_DIR) {
        return new BeancountBalanceDirImpl(node);
      }
      else if (type == COMMODITY_DIR) {
        return new BeancountCommodityDirImpl(node);
      }
      else if (type == COMPOUND_AMOUNT) {
        return new BeancountCompoundAmountImpl(node);
      }
      else if (type == COST_COMP) {
        return new BeancountCostCompImpl(node);
      }
      else if (type == COST_COMP_LIST) {
        return new BeancountCostCompListImpl(node);
      }
      else if (type == COST_SPEC) {
        return new BeancountCostSpecImpl(node);
      }
      else if (type == CURRENCY_SYMBOL) {
        return new BeancountCurrencySymbolImpl(node);
      }
      else if (type == CUSTOM_DIR) {
        return new BeancountCustomDirImpl(node);
      }
      else if (type == DIRECTIVE) {
        return new BeancountDirectiveImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new BeancountDivExprImpl(node);
      }
      else if (type == DOCUMENT_DIR) {
        return new BeancountDocumentDirImpl(node);
      }
      else if (type == EVENT_DIR) {
        return new BeancountEventDirImpl(node);
      }
      else if (type == INCLUDE_DIR) {
        return new BeancountIncludeDirImpl(node);
      }
      else if (type == KEY_VALUE) {
        return new BeancountKeyValueImpl(node);
      }
      else if (type == KEY_VALUE_VALUE) {
        return new BeancountKeyValueValueImpl(node);
      }
      else if (type == LINK_VALUE) {
        return new BeancountLinkValueImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new BeancountLiteralExprImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new BeancountMinusExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new BeancountMulExprImpl(node);
      }
      else if (type == NOTE_DIR) {
        return new BeancountNoteDirImpl(node);
      }
      else if (type == OPEN_DIR) {
        return new BeancountOpenDirImpl(node);
      }
      else if (type == OPTION_DIR) {
        return new BeancountOptionDirImpl(node);
      }
      else if (type == PAD_DIR) {
        return new BeancountPadDirImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new BeancountParenExprImpl(node);
      }
      else if (type == PLUGIN_DIR) {
        return new BeancountPluginDirImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new BeancountPlusExprImpl(node);
      }
      else if (type == POSTING_LINE) {
        return new BeancountPostingLineImpl(node);
      }
      else if (type == POSTING_LIST) {
        return new BeancountPostingListImpl(node);
      }
      else if (type == POSTING_PRICE) {
        return new BeancountPostingPriceImpl(node);
      }
      else if (type == PRICE_DIR) {
        return new BeancountPriceDirImpl(node);
      }
      else if (type == QUERY_DIR) {
        return new BeancountQueryDirImpl(node);
      }
      else if (type == TAG_LINK) {
        return new BeancountTagLinkImpl(node);
      }
      else if (type == TAG_VALUE) {
        return new BeancountTagValueImpl(node);
      }
      else if (type == TRANSACTION_DIR) {
        return new BeancountTransactionDirImpl(node);
      }
      else if (type == UNARY_MIN_EXPR) {
        return new BeancountUnaryMinExprImpl(node);
      }
      else if (type == UNARY_PLUS_EXPR) {
        return new BeancountUnaryPlusExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
