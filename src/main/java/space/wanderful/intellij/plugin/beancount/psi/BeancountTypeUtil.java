package space.wanderful.intellij.plugin.beancount.psi;

import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.ACCOUNT;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.ACCOUNT_DELIMITER;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.ACCOUNT_NAME;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.ACCOUNT_SEGMENT;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.ACCOUNT_WORD;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.BALANCE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.COMMODITY;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.CUSTOM;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.DOCUMENT;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.EVENT;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.INCLUDE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.NOTE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.OPEN;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.OPTION;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.PAD;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.PLUGIN;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.PRICE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.QUERY;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.TXN;

import com.intellij.psi.tree.TokenSet;

public class BeancountTypeUtil
{
    public final static TokenSet ACCOUNT_TOKENS = TokenSet.create(
        ACCOUNT, ACCOUNT_DELIMITER, ACCOUNT_NAME, ACCOUNT_SEGMENT, ACCOUNT_WORD//, COLON
    );
    public final static TokenSet DIRECTIVE_KEYWORDS = TokenSet.create(
        BALANCE,
        COMMODITY,
        CUSTOM,
        DOCUMENT,
        EVENT,
        INCLUDE,
        NOTE,
        OPEN,
        OPTION,
        PAD,
        PLUGIN,
        PRICE,
        QUERY,
        TXN
    );

}
