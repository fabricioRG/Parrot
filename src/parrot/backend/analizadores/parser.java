
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package parrot.backend.analizadores;

import java_cup.runtime.*;
import parrot.backend.analizadores.sym;
import parrot.backend.manejadores.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\025\000\002\002\004\000\002\002\011\000\002\002" +
    "\006\000\002\003\005\000\002\003\004\000\002\004\005" +
    "\000\002\005\003\000\002\006\007\000\002\007\006\000" +
    "\002\010\005\000\002\010\004\000\002\011\005\000\002" +
    "\012\012\000\002\013\007\000\002\014\007\000\002\015" +
    "\003\000\002\015\003\000\002\015\003\000\002\015\003" +
    "\000\002\015\003\000\002\016\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\100\000\004\045\011\001\002\000\004\002\102\001" +
    "\002\000\004\045\077\001\002\000\004\045\074\001\002" +
    "\000\004\045\041\001\002\000\004\045\ufffb\001\002\000" +
    "\006\053\012\055\013\001\002\000\004\057\031\001\002" +
    "\000\004\046\014\001\002\000\004\045\017\001\002\000" +
    "\004\045\025\001\002\000\004\045\021\001\002\000\004" +
    "\053\012\001\002\000\004\045\025\001\002\000\006\053" +
    "\012\056\022\001\002\000\004\046\023\001\002\000\004" +
    "\002\000\001\002\000\004\045\ufffe\001\002\000\004\054" +
    "\026\001\002\000\004\046\027\001\002\000\004\045\ufffc" +
    "\001\002\000\004\045\ufffd\001\002\000\004\047\032\001" +
    "\002\000\004\050\033\001\002\000\004\004\034\001\002" +
    "\000\004\050\035\001\002\000\004\046\036\001\002\000" +
    "\004\045\ufff5\001\002\000\004\045\070\001\002\000\004" +
    "\045\064\001\002\000\004\060\042\001\002\000\004\057" +
    "\043\001\002\000\004\047\044\001\002\000\004\050\046" +
    "\001\002\000\004\045\ufff4\001\002\000\014\014\053\020" +
    "\054\021\052\022\051\023\050\001\002\000\004\050\055" +
    "\001\002\000\004\050\uffee\001\002\000\004\050\uffef\001" +
    "\002\000\004\050\ufff0\001\002\000\004\050\ufff2\001\002" +
    "\000\004\050\ufff1\001\002\000\004\046\056\001\002\000" +
    "\004\051\057\001\002\000\004\032\061\001\002\000\004" +
    "\045\ufff3\001\002\000\004\052\062\001\002\000\004\045" +
    "\uffed\001\002\000\004\045\070\001\002\000\006\060\042" +
    "\063\065\001\002\000\004\046\066\001\002\000\004\045" +
    "\ufffa\001\002\000\004\045\ufff8\001\002\000\004\061\071" +
    "\001\002\000\004\046\072\001\002\000\004\045\ufff6\001" +
    "\002\000\004\045\ufff7\001\002\000\004\062\075\001\002" +
    "\000\004\046\076\001\002\000\004\045\ufff9\001\002\000" +
    "\004\054\100\001\002\000\004\046\101\001\002\000\004" +
    "\002\uffff\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\100\000\014\002\003\005\004\006\007\007\006\012" +
    "\005\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\010\037\013\036\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\003\015\005\014\006\007\007\006\012\005\001" +
    "\001\000\004\004\027\001\001\000\012\005\017\006\007" +
    "\007\006\012\005\001\001\000\002\001\001\000\004\004" +
    "\023\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\011\072\001\001" +
    "\000\004\013\062\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\014\044\001\001\000\002" +
    "\001\001\000\004\015\046\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\016" +
    "\057\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\011\066\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




	private ManejadorParser mp = null;


	// Connect this parser to a scanner!
	public parser(Lexer1 lex, ManejadorParser mp) {
		super(lex);
		this.mp = mp;
	}

        public void syntax_error(Symbol cur_token) {
        	this.mp.showErrorMessege("Error sintactico en <" + cur_token.value + ">");
            System.out.println("Error sintactico en <" + cur_token.value + ">");
        }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= main EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // main ::= SIGNO_MENOR ACCIONES_ABIERTO SIGNO_MAYOR main2 SIGNO_MENOR ACCIONES_CERRADO SIGNO_MAYOR 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("main",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // main ::= main3 SIGNO_MENOR ACCION_CERRADO SIGNO_MAYOR 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("main",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // main2 ::= main2 main3 mainAux 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("main2",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // main2 ::= main3 mainAux 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("main2",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // mainAux ::= SIGNO_MENOR ACCION_CERRADO SIGNO_MAYOR 
            {
              String RESULT =null;
		System.out.println("</accion>");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mainAux",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // main3 ::= ope1 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("main3",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ope1 ::= op1 op2 SIGNO_MENOR PARAMETROS_CERRADO SIGNO_MAYOR 
            {
              String RESULT =null;
		System.out.println("</parametros>");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ope1",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // op1 ::= op3 SIGNO_MENOR PARAMETROS_ABIERTO SIGNO_MAYOR 
            {
              String RESULT =null;
		System.out.println("<parametros>");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op1",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // op2 ::= op2 op4 op2Aux 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("op2",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // op2 ::= op4 op2Aux 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("op2",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // op2Aux ::= SIGNO_MENOR PARAMETRO_CERRADO SIGNO_MAYOR 
            {
              String RESULT =null;
		System.out.println("</parametro>");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op2Aux",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // op3 ::= SIGNO_MENOR ACCION_ABIERTO NOMBRE SIGNO_IGUAL COMILLAS NUEVO_SITIO_WEB COMILLAS SIGNO_MAYOR 
            {
              String RESULT =null;
		System.out.println("<accion nombre = 'NUEVO_SITIO_WEB'>");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op3",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // op4 ::= SIGNO_MENOR PARAMETRO_ABIERTO NOMBRE SIGNO_IGUAL op5 
            {
              String RESULT =null;
		System.out.println("<parametro nombre = ");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op4",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // op5 ::= COMILLAS op6 COMILLAS SIGNO_MAYOR op7 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		RESULT = e1; System.out.print("'" + RESULT +"' >");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op5",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // op6 ::= ID_TEXTO 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = e1;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op6",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // op6 ::= USUARIO_CREACION 
            {
              String RESULT =null;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = e2;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op6",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // op6 ::= FECHA_CREACION 
            {
              String RESULT =null;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e3 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = e3;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op6",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // op6 ::= FECHA_MODIFICACION 
            {
              String RESULT =null;
		int e4left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e4right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e4 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = e4;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op6",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // op6 ::= USUARIO_MODIFICACION 
            {
              String RESULT =null;
		int e5left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e5right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e5 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = e5;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op6",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // op7 ::= CORCHETE_ABIERTO TEXTO CORCHETE_CERRADO 
            {
              String RESULT =null;
		System.out.println("[TEXTO]");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op7",12, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
