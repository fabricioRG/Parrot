package parrot.backend.analizadores;

import java_cup.runtime.*;
import static parrot.backend.analizadores.sym1.*;

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
TextoString = "\"" [^*] ~"\"" | "\"" "\""
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
Comillas = "\""
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
Fecha = {CorcheteAbierto}{Space}{Entero}{Entero}{Entero}{Entero} "-" {Entero}{Entero} "-" {Entero}{Entero}{Space}{CorcheteCerrado}
HexadecimalParametro = {CorcheteAbierto} {Space} {NumeroHexadecimal} {Space} {CorcheteCerrado}
Identificador = {Letra}({Letra}|{Digito}|"-"|"_"|"$")*
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
NuevoSitioWeb = {Comillas} {Space} "NUEVO_SITIO_WEB" {Space} {Comillas}
BorrarSitioWeb = {Comillas} {Space} "BORRAR_SITIO_WEB" {Space} {Comillas}
NuevaPagina = {Comillas} {Space} "NUEVA_PAGINA" {Space} {Comillas}
BorrarPagina = {Comillas} {Space} "BORRAR_PAGINA" {Space} {Comillas}
ModificarPagina = {Comillas} {Space} "MODIFICAR_PAGINA" {Space} {Comillas}
AgregarComponente = {Comillas} {Space} "AGREGAR_COMPONENTE" {Space} {Comillas}
BorrarComponente = {Comillas} {Space} "BORRAR_COMPONENTE" {Space} {Comillas}
ModificarComponente = {Comillas} {Space} "MODIFICAR_COMPONENTE" {Space} {Comillas}
IdTexto = {Comillas} {Space} "ID" {Space} {Comillas}
TituloTexto = {Comillas} {Space} "TITULO" {Space} {Comillas}
Sitio = {Comillas} {Space} "SITIO" {Space} {Comillas}
Padre = {Comillas} {Space} "PADRE" {Space} {Comillas}
UsuarioCreacion = {Comillas} {Space} "USUARIO_CREACION" {Space} {Comillas}
FechaCreacion = {Comillas} {Space} "FECHA_CREACION" {Space} {Comillas}
FechaModificacion = {Comillas} {Space} "FECHA_MODIFICACION" {Space} {Comillas}
UsuarioModificacion = {Comillas} {Space} "USUARIO_MODIFICACION" {Space} {Comillas}
Pagina = {Comillas} {Space} "PAGINA" {Space} {Comillas}
Clase = {Comillas} {Space} "CLASE" {Space} {Comillas}
Texto = {Comillas} {Space} "TEXTO" {Space} {Comillas}
Alineacion = {Comillas} {Space} "ALINEACION" {Space} {Comillas}
Color = {Comillas} {Space} "COLOR" {Space} {Comillas}
Origen = {Comillas} {Space} "ORIGEN" {Space} {Comillas}
Altura = {Comillas} {Space} "ALTURA" {Space} {Comillas}
Ancho = {Comillas} {Space} "ANCHO" {Space} {Comillas}
EtiquetasTexto = {Comillas} {Space} "ETIQUETAS" {Space} {Comillas}


%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	{NuevoSitioWeb} {return symbol(NUEVO_SITIO_WEB, yytext());}
	{BorrarSitioWeb} {return symbol(BORRAR_SITIO_WEB, yytext());}
	{NuevaPagina} {return symbol(NUEVA_PAGINA, yytext());}
	{BorrarPagina} {return symbol(BORRAR_PAGINA, yytext());}
	{ModificarPagina} {return symbol(MODIFICAR_PAGINA, yytext());}
	{AgregarComponente} {return symbol(AGREGAR_COMPONENTE, yytext());}
	{BorrarComponente} {return symbol(BORRAR_COMPONENTE, yytext());}
	{ModificarComponente} {return symbol(MODIFICAR_COMPONENTE, yytext());}
	{IdTexto} {return symbol(ID_TEXTO, yytext());}
	{TituloTexto} {return symbol(TITULO, yytext());}
	{Sitio} {return symbol(SITIO, yytext());}
	{Padre} {return symbol(PADRE, yytext());}
	{UsuarioCreacion} {return symbol(USUARIO_CREACION, yytext());}
	{FechaCreacion} {return symbol(FECHA_CREACION, yytext());}
	{FechaModificacion} {return symbol(FECHA_MODIFICACION, yytext());}
	{UsuarioModificacion} {return symbol(USUARIO_MODIFICACION, yytext());}
	{Pagina} {return symbol(PAGINA, yytext());}
	{Clase} {return symbol(CLASE, yytext());}
	{Texto} {return symbol(TEXTO, yytext());}
	{Alineacion} {return symbol(ALINEACION, yytext());}
	{Color} {return symbol(COLOR, yytext());}
	{Origen} {return symbol(ORIGEN, yytext());}
	{Altura} {return symbol(ALTURA, yytext());}
	{Ancho} {return symbol(ANCHO, yytext());}
	{EtiquetasTexto} {return symbol(ETIQUETAS, yytext());}
	"<" {return symbol(SIGNO_MENOR, yytext());}
	">" {return symbol(SIGNO_MAYOR, yytext());}
	"=" {return symbol(SIGNO_IGUAL, yytext());}
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
	{TextoString} {return symbol(TEXTO_STRING, yytext());}
	{EnteroParametro} {return symbol(ENTERO_PARAMETRO, yytext());}
	{TextoParametro} {return symbol(TEXTO_PARAMETRO, yytext());}
	{Slash}	{return symbol(SLASH, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}

}
[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
