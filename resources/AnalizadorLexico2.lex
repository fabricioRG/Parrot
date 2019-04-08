 package parrot.backend.analizadores;

import java_cup.runtime.*;
import static parrot.backend.analizadores.sym2.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%public
%class Lexer2
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
Slash = "/"
Comillas = "\""
Space = ({WhiteSpace})*
CorcheteAbierto = "["
CorcheteCerrado = "]"
SignoMenor = "<"
SignoMayor = ">"
SitioWeb = {SignoMenor} "sitioWeb" {SignoMayor}
SitioWebCerrado = {SignoMenor}{Slash} "sitioWeb" {SignoMayor}
Id = {SignoMenor} "id" {SignoMayor}
IdCerrado = {SignoMenor}{Slash} "id" {SignoMayor}
UsuarioCreacion = {SignoMenor} "usuarioCreacion" {SignoMayor} 
UsuarioCreacionCerrado = {SignoMenor}{Slash} "usuarioCreacion" {SignoMayor} 
UsuarioModificacion = {SignoMenor} "usuarioModificacion" {SignoMayor}
UsuarioModificacionCerrado = {SignoMenor}{Slash} "usuarioModificacion" {SignoMayor}
FechaCreacion = {SignoMenor} "fechaCreacion" {SignoMayor}
FechaCreacionCerrado = {SignoMenor}{Slash} "fechaCreacion" {SignoMayor}
FechaModificacion = {SignoMenor} "fechaModificacion" {SignoMayor}
FechaModificacionCerrado = {SignoMenor}{Slash} "fechaModificacion" {SignoMayor}
PaginaWeb = {SignoMenor} "paginaWeb" {SignoMayor}
PaginaWebCerrado = {SignoMenor}{Slash} "paginaWeb" {SignoMayor}
Titulo = {SignoMenor} "titulo" {SignoMayor}
TituloCerrado = {SignoMenor}{Slash} "titulo" {SignoMayor}
Sitio = {SignoMenor} "sitio" {SignoMayor}
SitioCerrado = {SignoMenor}{Slash} "sitio" {SignoMayor}
Padre = {SignoMenor} "padre" {SignoMayor}
PadreCerrado = {SignoMenor}{Slash} "padre" {SignoMayor}
Componente = {SignoMenor} "componente" {SignoMayor}
ComponenteCerrado = {SignoMenor}{Slash} "componente" {SignoMayor}
Pagina = {SignoMenor} "pagina" {SignoMayor}
PaginaCerrado = {SignoMenor}{Slash} "pagina" {SignoMayor}
Texto = {SignoMenor} "texto" {SignoMayor}
TextoCerrado = {SignoMenor}{Slash} "texto" {SignoMayor}
Alineacion = {SignoMenor} "alineacion" {SignoMayor}
AlineacionCerrado = {SignoMenor}{Slash} "alineacion" {SignoMayor}
Color = {SignoMenor} "color" {SignoMayor}
ColorCerrado = {SignoMenor}{Slash} "color" {SignoMayor}
Parrafo = {SignoMenor} "parrafo" {SignoMayor}
ParrafoCerrado = {SignoMenor}{Slash} "parrafo" {SignoMayor}
Imagen = {SignoMenor} "imagen" {SignoMayor}
ImagenCerrado = {SignoMenor}{Slash} "imagen" {SignoMayor}
Origen = {SignoMenor} "origen" {SignoMayor}
OrigenCerrado = {SignoMenor}{Slash} "origen" {SignoMayor}
Altura = {SignoMenor} "altura" {SignoMayor}
AlturaCerrado = {SignoMenor}{Slash} "altura" {SignoMayor}
Ancho = {SignoMenor} "ancho" {SignoMayor}
AnchoCerrado = {SignoMenor}{Slash} "ancho" {SignoMayor}
Video = {SignoMenor} "video" {SignoMayor}
VideoCerrado = {SignoMenor}{Slash} "video" {SignoMayor}
Menu = {SignoMenor} "menu" {SignoMayor}
MenuCerrado = {SignoMenor}{Slash} "menu" {SignoMayor}
Paginas = {SignoMenor} "paginas" {SignoMayor}
PaginasCerrado = {SignoMenor}{Slash} "paginas" {SignoMayor}
Componentes = {SignoMenor} "componentes" {SignoMayor}
ComponentesCerrado = {SignoMenor}{Slash} "componentes" {SignoMayor}
Etiquetas = {SignoMenor} "etiquetas" {SignoMayor}
EtiquetasCerrado = {SignoMenor}{Slash} "etiquetas" {SignoMayor}
Etiqueta = {SignoMenor} "etiqueta" {SignoMayor}
EtiquetaCerrado = {SignoMenor}{Slash} "etiqueta" {SignoMayor}
Path = {SignoMenor} "path" {SignoMayor}
PathCerrado = {SignoMenor}{Slash} "path" {SignoMayor}
LetraNumero = ({Letra}|{Entero})
NumeroHexadecimal = "#" {LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}
Fecha = {CorcheteAbierto}{Entero}{Entero}{Entero}{Entero} "-" {Entero}{Entero} "-" {Entero}{Entero}{CorcheteCerrado}
HexadecimalParametro = {CorcheteAbierto}{NumeroHexadecimal}{CorcheteCerrado}
Identificador = {Letra}({Letra}|{Digito}|"-"|"_"|"$")*
IdentificadorParametro = {CorcheteAbierto}{Identificador}{CorcheteCerrado}
EnteroParametro = {CorcheteAbierto}{Digito}{CorcheteCerrado}
Centrar = {CorcheteAbierto} "CENTRAR" {CorcheteCerrado}
Izquierda = {CorcheteAbierto} "IZQUIERDA" {CorcheteCerrado}
Derecha = {CorcheteAbierto} "DERECHA" {CorcheteCerrado}
Justificar = {CorcheteAbierto} "JUSTIFICAR" {CorcheteCerrado}

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	{SitioWeb} {return symbol(SITIO_WEB_ABIERTO, yytext());}
	{SitioWebCerrado} {return symbol(SITIO_WEB_CERRADO, yytext());}
	{Id} {return symbol(ID_ABIERTO, yytext());}
	{IdCerrado} {return symbol(ID_CERRADO, yytext());}
	{UsuarioCreacion} {return symbol(USUARIO_CREACION_ABIERTO, yytext());}
	{UsuarioCreacionCerrado} {return symbol(USUARIO_CREACION_CERRADO, yytext());}
	{UsuarioModificacion} {return symbol(USUARIO_MODIFICACION_ABIERTO, yytext());}
	{UsuarioModificacionCerrado} {return symbol(USUARIO_MODIFICACION_CERRADO, yytext());}
	{FechaCreacion} {return symbol(FECHA_CREACION_ABIERTO, yytext());}
	{FechaCreacionCerrado} {return symbol(FECHA_CREACION_CERRADO, yytext());}
	{FechaModificacion} {return symbol(FECHA_MODIFICACION_ABIERTO, yytext());}
	{FechaModificacionCerrado} {return symbol(FECHA_MODIFICACION_CERRADO, yytext());}
	{PaginaWeb} {return symbol(PAGINA_WEB_ABIERTO, yytext());}
	{PaginaWebCerrado} {return symbol(PAGINA_WEB_CERRADO, yytext());}
	{Titulo} {return symbol(TITULO_ABIERTO, yytext());}
	{TituloCerrado} {return symbol(TITULO_CERRADO, yytext());}
	{Sitio} {return symbol(SITIO_ABIERTO, yytext());}
	{SitioCerrado} {return symbol(SITIO_CERRADO, yytext());}
	{Padre} {return symbol(PADRE_ABIERTO, yytext());}
	{PadreCerrado} {return symbol(PADRE_CERRADO, yytext());}
	{Componentes} {return symbol(COMPONENTES_ABIERTO, yytext());}
	{ComponentesCerrado} {return symbol(COMPONENTES_CERRADO, yytext());}
	{Componente} {return symbol(COMPONENTE_ABIERTO, yytext());}
	{ComponenteCerrado} {return symbol(COMPONENTE_CERRADO, yytext());}
	{Paginas} {return symbol(PAGINAS_ABIERTO, yytext());}
	{PaginasCerrado} {return symbol(PAGINAS_CERRADO, yytext());}
	{Pagina} {return symbol(PAGINA_ABIERTA, yytext());}
	{PaginaCerrado} {return symbol(PAGINA_CERRADO, yytext());}
	{Texto} {return symbol(TEXTO_ABIERTO, yytext());}
	{TextoCerrado} {return symbol(TEXTO_CERRADO, yytext());}
	{Alineacion} {return symbol(ALINEACION_ABIERTO, yytext());}
	{AlineacionCerrado} {return symbol(ALINEACION_CERRADO, yytext());}
	{Color} {return symbol(COLOR_ABIERTO, yytext());}
	{ColorCerrado} {return symbol(COLOR_CERRADO, yytext());}
	{Parrafo} {return symbol(PARRAFO_ABIERTO, yytext());}
	{ParrafoCerrado} {return symbol(PARRAFO_CERRADO, yytext());}
	{Imagen} {return symbol(IMAGEN_ABIERTO, yytext());}
	{ImagenCerrado} {return symbol(IMAGEN_CERRADO, yytext());}
	{Origen} {return symbol(ORIGEN_ABIERTO, yytext());}
	{OrigenCerrado} {return symbol(ORIGEN_CERRADO, yytext());}
	{Altura} {return symbol(ALTURA_ABIERTO, yytext());}
	{AlturaCerrado} {return symbol(ALTURA_CERRADO, yytext());}
	{Ancho} {return symbol(ANCHO_ABIERTO, yytext());}
	{AnchoCerrado} {return symbol(ANCHO_CERRADO, yytext());}
	{Video} {return symbol(VIDEO_ABIERTO, yytext());}
	{VideoCerrado} {return symbol(VIDEO_CERRADO, yytext());}
	{Menu} {return symbol(MENU_ABIERTO, yytext());}
	{MenuCerrado} {return symbol(MENU_CERRADO, yytext());}
	{Etiquetas} {return symbol(ETIQUETAS_ABIERTO, yytext());}
	{EtiquetasCerrado} {return symbol(ETIQUETAS_CERRADO, yytext());}
	{Etiqueta} {return symbol(ETIQUETA_ABIERTO, yytext());}
	{EtiquetaCerrado} {return symbol(ETIQUETA_CERRADO, yytext());}
	{Path} {return symbol(PATH_ABIERTO, yytext());}
	{PathCerrado} {return symbol(PATH_CERRADO, yytext());}
	{Centrar} {return symbol(CENTRAR_PARAMETRO, yytext());}
	{Izquierda} {return symbol(IZQUIERDA_PARAMETRO, yytext());}
	{Derecha} {return symbol(DERECHA_PARAMETRO, yytext());}
	{Justificar} {return symbol(JUSTIFICAR_PARAMETRO, yytext());}
	{HexadecimalParametro} {return symbol(HEXADECIMAL_PARAMETRO, yytext());}
	{EnteroParametro} {return symbol(ENTERO_PARAMETRO, yytext());}
	{Fecha} {return symbol(FECHA_PARAMETRO, yytext());}
	{IdentificadorParametro} {return symbol(IDENTIFICADOR, yytext());}
	{TextoParametro} {return symbol(TEXTO_PARAMETRO, yytext());}
	{Slash}	{return symbol(SLASH, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}

}
[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
