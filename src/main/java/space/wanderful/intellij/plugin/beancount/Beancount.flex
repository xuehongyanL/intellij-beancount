package space.wanderful.intellij.plugin.beancount.parser;

import java.util.LinkedList;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.*;
import static space.wanderful.intellij.plugin.beancount.BeancountLexerUtil.*;

%%

%{
  public _BeancountLexer() {
    this((java.io.Reader)null);
  }

  private final LinkedList<Integer> states = new LinkedList();

  private void yypushstate(int state) {
      states.addFirst(yystate());
        yylogstate(state);
  }

    private void yypopstate() {
      if(states.isEmpty()) {
        yylogstate(YYINITIAL);
      } else  {
        final int state = states.removeFirst();
        yylogstate(state);
      }
    }
    private void yylogstate(int state) {
//    System.out.println("   state is now "+ state);
    yybegin(state);
    }

%}

//%debug
%public
%class _BeancountLexer
%implements FlexLexer
%function advance
%type IElementType
%eof{  return;
%eof}

%unicode

//EOL=\R
WHITE_SPACE=\s+

NUMBER=(\d+)((\d{1,3})*([\,]\d{3})*)(\.\d+)?
NEGATIVE_NUMBER=-{NUMBER}
DATE=[:digit:]{4}-[:digit:]{2}-[:digit:]{2}
STRING=(\"([^\"\\]|\\.)*\")
COMMENT=;.*
EOL_SINGLE=[\n\r]
EOL=[\n\r]+
LINE_SPACE=[ ]+
FLAG=[*!]
ACCOUNT_START=[:uppercase:]
ACCOUNT_PART=[a-zA-Z0-9_-]+
ACCOUNT_WORD={ACCOUNT_START}{ACCOUNT_PART}*
CURRENCY=[A-Z][A-Z_-]*[A-Z]
META_KEY=[a-z][a-zA-Z0-9_-]+
TAG_LINK_VAL=[A-Za-z0-9\-_/.]+

// i know this probably isn't a "good" lexer design, it is too stateful but :\ it's my first one
%state sOPT, sEVENT, sDATE_ENTRY, sOPEN, sBALANCE, sPRICE, sCOMMODITY, sMETA_LIST, sPOSTING, sACCOUNT, sCUSTOM, sPAD, sQUERY, sNOTE, sDOCUMENT, sINCLUDE,sPLUGIN
%xstate sTXN

%%

<sACCOUNT> {
{LINE_SPACE}+       { yypopstate(); return WHITE_SPACE; }
{EOL_SINGLE}        { yypushback(yylength()); yypopstate(); }
":"                 { return COLON; }
{ACCOUNT_WORD}      { return ACCOUNT_WORD; }
}

^{LINE_SPACE}+{META_KEY} {  yypushback(nonWsIndex(yytext())); yypushstate(sMETA_LIST); return INDENT; }
{CURRENCY}          { return CURRENCY; }

<sOPT, sEVENT, sPRICE, sINCLUDE, sQUERY, sPLUGIN> {
{EOL}               { yylogstate(YYINITIAL); return EOL; }
{LINE_SPACE}+       { return WHITE_SPACE; }
{STRING}            { return STRING; }
}

<sCOMMODITY> {
{EOL}               { yylogstate(YYINITIAL); return EOL; }
{LINE_SPACE}+       { return WHITE_SPACE; }
}
<sOPEN, sBALANCE, sCUSTOM, sPAD, sNOTE, sDOCUMENT> {
{EOL}               { yylogstate(YYINITIAL); return EOL; }
{LINE_SPACE}+       { return WHITE_SPACE; }
{ACCOUNT_WORD}      { yypushstate(sACCOUNT); return ACCOUNT_WORD; }
}

<sTXN> {
"#"                  { return HASH; }
"^"                  { return CARET; }
{TAG_LINK_VAL}       { return TAG_LINK_VALUE; }
^{LINE_SPACE}+{META_KEY} {  yypushback(nonWsIndex(yytext())); yypushstate(sMETA_LIST); return INDENT; }
{EOL}{2}             { yypopstate();  return EOL; }
{EOL}                { return EOL; }
^{LINE_SPACE}+{ACCOUNT_WORD} { yypushback(nonWsIndex(yytext())); yypushstate(sPOSTING); yypushstate(sACCOUNT); return INDENT;}
{LINE_SPACE}+        { return WHITE_SPACE; }
{STRING}             { return STRING; }
[^]                  { /*this effectively detects the last posting line*/ yypushback(yylength()); yypopstate(); }
}
<sMETA_LIST> {
{META_KEY}           { return META_KEY; }
{LINE_SPACE}+        { return WHITE_SPACE; }
":"                  { return META_KV_DELIMITER; }
{EOL}                { yypopstate(); return EOL; }
}


<sPOSTING> {
{LINE_SPACE}         { return WHITE_SPACE; }
{EOL_SINGLE}         { yypushback(yylength()); yypopstate(); }
}

<sDATE_ENTRY> {
  {LINE_SPACE}+      { return WHITE_SPACE; }
  "price"            { yylogstate(sPRICE); return PRICE; }
  "open"             { yylogstate(sOPEN); return OPEN; }
  "balance"          { yylogstate(sBALANCE); return BALANCE; }
  "commodity"        { yylogstate(sCOMMODITY); return COMMODITY; }
  "event"            { yylogstate(sEVENT); return EVENT; }
  "txn"|{FLAG}       { yylogstate(sTXN); return TXN; }
  "custom"           { yylogstate(sCUSTOM); return CUSTOM;}
  "pad"              { yylogstate(sPAD); return PAD;}
  "note"             { yylogstate(sNOTE); return NOTE;}
  "document"         { yylogstate(sDOCUMENT); return DOCUMENT;}
  "query"            { yylogstate(sQUERY); return QUERY;}
}

<YYINITIAL> {
  ^"option"         { yylogstate(sOPT); return OPTION; }
  ^"include"        { yylogstate(sINCLUDE); return INCLUDE;}
  ^"plugin"        { yylogstate(sPLUGIN); return PLUGIN;}
  ^{DATE}           { yylogstate(sDATE_ENTRY); return DATE; }
  {COMMENT}         { return COMMENT; }
  {EOL}             { return EOL; }
}

"TRUE"              { return BOOLEAN; }
"FALSE"             { return BOOLEAN; }
"{{"                { return LCURLCURL; }
"}}"                { return RCURLCURL; }
"{"                 { return LCURL; }
"}"                 { return RCURL; }
","                 { return COMMA; }
"#"                 { return HASH; }
"@@"                { return ATAT; }
"@"                 { return AT;}
"("                 { return LPAREN; }
")"                 { return RPAREN; }
"-"                 { return MINUS; }
\+                  { return PLUS; }
"/"                 { return DIVIDE; }
"*"                 { return ASTERISK; }
{DATE}              { return DATE; }
{NUMBER}            { return NUMBER; }
{NEGATIVE_NUMBER}   { return NEGATIVE_NUMBER; }
{STRING}            { return STRING; }

<sOPT, sEVENT, sDATE_ENTRY, sOPEN, sBALANCE, sCOMMODITY, sMETA_LIST, sPOSTING, sACCOUNT, sTXN, sPRICE, sCUSTOM, sPAD, sDOCUMENT, sNOTE, sQUERY, sINCLUDE, sPLUGIN>
{
    [^] { return BAD_CHARACTER; }
}
[^] { return SKIP; }
