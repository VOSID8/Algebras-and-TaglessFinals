error id: file:///C:/Projects/Algebras-and-TaglessFinals/src/main/TaglessFinal.scala:[800..801) in Input.VirtualFile("file:///C:/Projects/Algebras-and-TaglessFinals/src/main/TaglessFinal.scala", "import scala.quoted.Expr

object TaglessFinal {

    //expression problem

    object ExpressionProblem {
        trait Expr
        case class B(boolean: Boolean) extends Expr
        case class Or(left: Expr, right: Expr) extends Expr
        case class And(left: Expr, right: Expr) extends Expr
        case class Not(expr: Expr) extends Expr

        val aGiantExpression: Expr = And(Or(B(true), B(false)), Not(B(true))) 
        //expression 

        def eval(expr: Expr): Boolean = expr match {
            case B(b) => b
            case Or(a,b) => eval(a) || eval(b)
            case And(a,b) => eval(a) && eval(b)
            case Not(a) => !eval(a)
        }

        //eval(aGiantExpression)

        //include ints 
        case class I(int: Int) extends Expr
        case class 



    }
}
")
file:///C:/Projects/Algebras-and-TaglessFinals/src/main/TaglessFinal.scala
file:///C:/Projects/Algebras-and-TaglessFinals/src/main/TaglessFinal.scala:32: error: expected identifier; obtained rbrace
    }
    ^
#### Short summary: 

expected identifier; obtained rbrace