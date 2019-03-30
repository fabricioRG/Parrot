package parrot.backend.analizadores;

import java_cup.runtime.*;
import static parrot.backend.analizadores.sym.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%public
%class Lexer1
%cup
%cupdebug
%line
%column

%{
    StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]
Letra = [a-zA-Z]
Entero = [0-9]
Digito = [1-9][0-9]*
TextoParametro = "[" [^*] ~"]" | "[" "]"
A = "A" | "a"
B = "B" | "b"
C = "C" | "c"
E = "E" | "e"
I = "I" | "i"
L = "L" | "l"
M = "M" | "m"
N = "N" | "n"
O = "O" | "o"
P = "P" | "p"
Q = "Q" | "q"
R = "R" | "r"
S = "S" | "s"
T = "T" | "t"
U = "U" | "u"
V = "V" | "v"
X = "X" | "x"
Slash = "/"
Space = ({WhiteSpace})*
CorcheteAbierto = "["
CorcheteCerrado = "]"
Accion = {A}{C}{C}{I}{O}{N}
AccionCerrado = {Slash}{Accion}
Acciones = {A}{C}{C}{I}{O}{N}{E}{S}
AccionesCerrado = {Slash}{Acciones}
Nombre = {N}{O}{M}{B}{R}{E}
Parametro = {P}{A}{R}{A}{M}{E}{T}{R}{O}
ParametroCerrado = {Slash}{Parametro}
Parametros = {P}{A}{R}{A}{M}{E}{T}{R}{O}{S}
ParametrosCerrado = {Slash}{Parametros}
Etiqueta = {E}{T}{I}{Q}{U}{E}{T}{A}
EtiquetaCerrado = {Slash}{Etiqueta}
Etiquetas = {E}{T}{I}{Q}{U}{E}{T}{A}{S}
EtiquetasCerrado = {Slash}{Etiquetas}
Valor = {V}{A}{L}{O}{R}
Atributo = {A}{T}{R}{I}{B}{U}{T}{O}
AtributoCerrado = {Slash}{Atributo}
Atributos = {A}{T}{R}{I}{B}{U}{T}{O}{S}
AtributosCerrado = {Slash}{Atributos}
LetraNumero = ({Letra}|{Entero})
NumeroHexadecimal = "#" {LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}
Fecha = {CorcheteAbierto}{Space}{Entero}{Entero}{Entero}{Entero} "-" {Entero}{Entero} "-" {Entero}{Space}{CorcheteCerrado}
HexadecimalParametro = {CorcheteAbierto} {Space} {NumeroHexadecimal} {Space} {CorcheteCerrado}
Identificador = ({Letra})({Letra}|{Digito}|"-"|"_"|"$")*
IdentificadorParametro = {CorcheteAbierto} {Space} {Identificador} {Space} {CorcheteCerrado}
EnteroParametro = {CorcheteAbierto} {Space} {Digito} {Space} {CorcheteCerrado}
Titulo = {CorcheteAbierto} {Space} "TITULO" {Space} {CorcheteCerrado}
Parrafo = {CorcheteAbierto} {Space} "PARRAFO" {Space} {CorcheteCerrado}
Imagen = {CorcheteAbierto} {Space} "IMAGEN" {Space} {CorcheteCerrado}
Video = {CorcheteAbierto} {Space} "VIDEO" {Space} {CorcheteCerrado}
Menu = {CorcheteAbierto} {Space} "MENU" {Space} {CorcheteCerrado}
Centrar = {CorcheteAbierto} {Space} "CENTRAR" {Space} {CorcheteCerrado}
Izquierda = {CorcheteAbierto} {Space} "IZQUIERDA" {Space} {CorcheteCerrado}
Derecha = {CorcheteAbierto} {Space} "DERECHA" {Space} {CorcheteCerrado}
Justificar = {CorcheteAbierto} {Space} "JUSTIFICAR" {Space} {CorcheteCerrado}

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	"NUEVO_SITIO_WEB" {return symbol(NUEVO_SITIO_WEB, yytext());}
	"BORRAR_SITIO_WEB" {return symbol(BORRAR_SITIO_WEB, yytext());}
	"NUEVA_PAGINA" {return symbol(NUEVA_PAGINA, yytext());}
	"BORRAR_PAGINA" {return symbol(BORRAR_PAGINA, yytext());}
	"MODIFICAR_PAGINA" {return symbol(MODIFICAR_PAGINA, yytext());}
	"AGREGAR_COMPONENTE" {return symbol(AGREGAR_COMPONENTE, yytext());}
	"BORRAR_COMPONENTE" {return symbol(BORRAR_COMPONENTE, yytext());}
	"MODIFICAR_COMPONENTE" {return symbol(MODIFICAR_COMPONENTE, yytext());}
	"ID" {return symbol(ID_TEXTO, yytext());}
	"TITULO" {return symbol(TITULO, yytext());}
	"SITIO" {return symbol(SITIO, yytext());}
	"PADRE" {return symbol(PADRE, yytext());}
	"USUARIO_CREACION" {return symbol(USUARIO_CREACION, yytext());}
	"FECHA_CREACION" {return symbol(FECHA_CREACION, yytext());}
	"FECHA_MODIFICACION" {return symbol(FECHA_MODIFICACION, yytext());}
	"USUARIO_MODIFICACION" {return symbol(USUARIO_MODIFICACION, yytext());}
	"PAGINA" {return symbol(PAGINA, yytext());}
	"CLASE" {return symbol(CLASE, yytext());}
	"TEXTO" {return symbol(TEXTO, yytext());}
	"ALINEACION" {return symbol(ALINEACION, yytext());}
	"COLOR" {return symbol(COLOR, yytext());}
	"ORIGEN" {return symbol(ORIGEN, yytext());}
	"ALTURA" {return symbol(ALTURA, yytext());}
	"ANCHO" {return symbol(ANCHO, yytext());}
	"ETIQUETAS" {return symbol(ETIQUETAS, yytext());}
	"<" {return symbol(SIGNO_MENOR, yytext());}
	">" {return symbol(SIGNO_MAYOR, yytext());}
	"=" {return symbol(SIGNO_IGUAL, yytext());}
	"\"" {return symbol(COMILLAS, yytext());}
	"|" {return symbol(OR, yytext());}
	{Centrar} {return symbol(CENTRAR_PARAMETRO, yytext());}
	{Izquierda} {return symbol(IZQUIERDA_PARAMETRO, yytext());}
	{Derecha} {return symbol(DERECHA_PARAMETRO, yytext());}
	{Justificar} {return symbol(JUSTIFICAR_PARAMETRO, yytext());}
	{Accion} {return symbol(ACCION_ABIERTO, yytext());}
	{AccionCerrado} {return symbol(ACCION_CERRADO, yytext());}
	{Acciones} {return symbol(ACCIONES_ABIERTO, yytext());}
	{AccionesCerrado} {return symbol(ACCIONES_CERRADO, yytext());}
	{Nombre} {return symbol(NOMBRE, yytext());}
	{Parametro} {return symbol(PARAMETRO_ABIERTO, yytext());}
	{ParametroCerrado} {return symbol(PARAMETRO_CERRADO, yytext());}
	{Parametros} {return symbol(PARAMETROS_ABIERTO, yytext());}
	{ParametrosCerrado} {return symbol(PARAMETROS_CERRADO, yytext());}
	{Etiqueta} {return symbol(ETIQUETA_ABIERTO, yytext());}
	{EtiquetaCerrado} {return symbol(ETIQUETA_CERRADO, yytext());}
	{Etiquetas} {return symbol(ETIQUETAS_ABIERTO, yytext());}
	{EtiquetasCerrado} {return symbol(ETIQUETAS_CERRADO, yytext());}
	{Atributo} {return symbol(ATRIBUTO_ABIERTO, yytext());}
	{AtributoCerrado} {return symbol(ATRIBUTO_CERRADO, yytext());}
	{Atributos} {return symbol(ATRIBUTOS_ABIERTO, yytext());}
	{AtributosCerrado} {return symbol(ATRIBUTOS_CERRADO, yytext());}
	{Valor} {return symbol(VALOR, yytext());}
	{Fecha} {return symbol(FECHA_PARAMETRO, yytext());}
	{HexadecimalParametro} {return symbol(HEXADECIMAL_PARAMETRO, yytext());}
	{Titulo} {return symbol(TITULO_PARAMETRO, yytext());}
	{Parrafo} {return symbol(PARRAFO_PARAMETRO, yytext());}
	{Imagen} {return symbol(IMAGEN_PARAMETRO, yytext());}
	{Video} {return symbol(VIDEO_PARAMETRO, yytext());}
	{Menu} {return symbol(MENU_PARAMETRO, yytext());}
	{IdentificadorParametro} {return symbol(IDENTIFICADOR, yytext());}
	{EnteroParametro} {return symbol(ENTERO_PARAMETRO, yytext());}
	{TextoParametro} {return symbol(TEXTO_PARAMETRO, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}

}
[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
