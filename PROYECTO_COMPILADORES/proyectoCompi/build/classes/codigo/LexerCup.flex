package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
   private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline,yycolumn,value);
    }
   private Symbol symbol (int type){
        return new Symbol (type, yyline,yycolumn);
    }
%}
%%
BYTE {return new Symbol(sym.BYTE, yychar, yyline,yytext());}
SHORT {return new Symbol(sym.SHORT, yychar, yyline,yytext());}
INT {return new Symbol(sym.INT, yychar, yyline,yytext());}
LONG {return new Symbol(sym.LONG, yychar, yyline,yytext());}
FLOAT {return new Symbol(sym.FLOAT, yychar, yyline,yytext());}
DOUBLE {return new Symbol(sym.DOUBLE, yychar, yyline,yytext());}
BOOLEAN {return new Symbol(sym.BOOLEAN, yychar, yyline,yytext());}
CHAR {return new Symbol(sym.CHAR, yychar, yyline,yytext());}
VERDADERO {return new Symbol(sym.VERDADERO, yychar, yyline,yytext());}
FALSO {return new Symbol(sym.FALSO, yychar, yyline,yytext());}
STRING {return new Symbol(sym.STRING, yychar, yyline,yytext());}
RETURN {return new Symbol(sym.RETURN, yychar, yyline,yytext());}
include {return new Symbol(sym.include, yychar, yyline,yytext());}

using {return new Symbol(sym.using, yychar, yyline,yytext());}
namespace {return new Symbol(sym.namespace, yychar, yyline,yytext());}
class {return new Symbol(sym.classT, yychar, yyline,yytext());}
public {return new Symbol(sym.publicT, yychar, yyline,yytext());}
double {return new Symbol(sym.doubleT, yychar, yyline,yytext());}
char {return new Symbol(sym.charT, yychar, yyline,yytext());}
switch {return new Symbol(sym.switchT, yychar, yyline,yytext());}
case {return new Symbol(sym.caseT, yychar, yyline,yytext());}
return {return new Symbol(sym.returnT, yychar, yyline,yytext());}
default {return new Symbol(sym.defaultT, yychar, yyline,yytext());}
endl {return new Symbol(sym.endlT, yychar, yyline,yytext());}
pragma  {return new Symbol(sym.pragmaT, yychar, yyline,yytext());}
once  {return new Symbol(sym.onceT, yychar, yyline,yytext());}

while {return new Symbol(sym.whileT, yychar, yyline,yytext());}
continue {return new Symbol(sym.continueT, yychar, yyline,yytext());}
if {return new Symbol(sym.ifT, yychar, yyline,yytext());}
else {return new Symbol(sym.elseT, yychar, yyline,yytext());}
true  {return new Symbol(sym.trueT, yychar, yyline,yytext());}
false  {return new Symbol(sym.falseT, yychar, yyline,yytext());}
"11/05/2024" {return new Symbol(sym.DAY, yychar, yyline,yytext());}

("=") {return new Symbol(sym.igual, yychar, yyline,yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
( ";" ) {return new Symbol(sym.puntoComa, yychar, yyline, yytext());}
( "{" ) {return new Symbol(sym.llaveApertura, yychar, yyline, yytext());}

( "}" ) {return new Symbol(sym.llaveCierre, yychar, yyline, yytext());}
( ">" ) {return new Symbol(sym.signoMenorQue, yychar, yyline, yytext());}
( "<" ) {return new Symbol(sym.signoMayorQue, yychar, yyline, yytext());}
( ":" ) {return new Symbol(sym.signoDosPuntos, yychar, yyline, yytext());}
( "#" ) {return new Symbol(sym.signoAlmohoadilla, yychar, yyline, yytext());}

( "," ) {return new Symbol(sym.signoComa, yychar, yyline, yytext());}
( "+" ) {return new Symbol(sym.signoMas, yychar, yyline, yytext());}
( "-" ) {return new Symbol(sym.signoMenos, yychar, yyline, yytext());}
( "*" ) {return new Symbol(sym.signoMultiplicacion, yychar, yyline, yytext());}
( "/" ) {return new Symbol(sym.signoSlash, yychar, yyline, yytext());}


( "(" ) {return new Symbol(sym.parentesisApertura, yychar, yyline, yytext());}
( ")" ) {return new Symbol(sym.parentesisCierre, yychar, yyline, yytext());}
( "." ) {return new Symbol(sym.signoPunto, yychar, yyline, yytext());}
( "|" ) {return new Symbol(sym.signoOr, yychar, yyline, yytext());}

{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

