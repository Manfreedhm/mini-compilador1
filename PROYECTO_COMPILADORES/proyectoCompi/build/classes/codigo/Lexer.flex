package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
BYTE {lexeme=yytext(); return BYTE;}
SHORT {lexeme=yytext(); return SHORT;}
INT {lexeme=yytext(); return INT;}
LONG {lexeme=yytext(); return LONG;}
FLOAT {lexeme=yytext(); return FLOAT;}
DOUBLE {lexeme=yytext(); return DOUBLE;}
BOOLEAN {lexeme=yytext(); return BOOLEAN;}
CHAR {lexeme=yytext(); return CHAR;}
VERDADERO {lexeme=yytext(); return VERDADERO;}
FALSO {lexeme=yytext(); return FALSO;}
STRING {lexeme=yytext(); return STRING;}
RETURN {lexeme=yytext(); return RETURN;}
include {lexeme=yytext(); return include;}

using {lexeme=yytext(); return using;}
namespace {lexeme=yytext(); return namespace;}
class {lexeme=yytext(); return classT;}
public {lexeme=yytext(); return publicT;}
double {lexeme=yytext(); return doubleT;}
char {lexeme=yytext(); return charT;}
switch {lexeme=yytext(); return switchT;}
case {lexeme=yytext(); return caseT;}
return {lexeme=yytext(); return returnT;}
default {lexeme=yytext(); return defaultT;}
endl {lexeme=yytext(); return endlT;}
pragma  {lexeme=yytext(); return pragmaT ;}
once  {lexeme=yytext(); return onceT ;}

while {lexeme=yytext(); return whileT;}
continue {lexeme=yytext(); return continueT;}
if {lexeme=yytext(); return ifT;}
else {lexeme=yytext(); return elseT;}
true  {lexeme=yytext(); return trueT ;}
false  {lexeme=yytext(); return falseT ;}
"11/05/2024"  {lexeme=yytext(); return DAY ;}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return linea;}
";" {lexeme=yytext(); return puntoComa;}
("=") {lexeme=yytext(); return igual;}
("{") {lexeme=yytext(); return llaveApertura;}
("}") {lexeme=yytext(); return llaveCierre;}
("<") {lexeme=yytext(); return signoMenorQue;}
(">") {lexeme=yytext(); return signoMayorQue;}
(":") {lexeme=yytext(); return signoDosPuntos;}
("#") {lexeme=yytext(); return signoAlmohoadilla;}
(",") {lexeme=yytext(); return signoComa;}
("+") {lexeme=yytext(); return signoMas;}
("-") {lexeme=yytext(); return signoMenos;}
("*") {lexeme=yytext(); return signoMultiplicacion;}
("/") {lexeme=yytext(); return signoSlash;}
("(") {lexeme=yytext(); return parentesisApertura;}
(")") {lexeme=yytext(); return parentesisCierre;}
(".") {lexeme=yytext(); return signoPunto;}
("|") {lexeme=yytext(); return signoOr;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}