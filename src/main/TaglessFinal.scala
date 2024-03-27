import scala.quoted.Expr

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
        case class Sum(left: Expr, right: Expr) extends Expr
        case class Mul(left: Expr, right: Expr) extends Expr

        def eval_v2(expr: Expr): Any = expr match {
            case B(b) => b
            case Or(a,b) => eval(a).asInstanceOf[Boolean] || eval(b).asInstanceOf[Boolean]
            //casts everywhere
        }
        //here we lost type safety
        //we can't use the same eval function for both the cases
        //we have to write a new eval function for the new case
        //this is the expression problem

        //how to structure the code so that we can add new cases without modifying the existing code
        //how to submit type Boolean and get Boolean and so on 

    object Solution1 {
        trait Expr(val tag: String)
        case class B(boolean: Boolean) extends Expr("bool")
        case class Or(left: Expr, right: Expr) extends Expr("bool") 
        case class And(left: Expr, right: Expr) extends Expr("bool"){
            assert(left.tag == "bool" && right.tag == "bool")
        }
        case class Not(expr: Expr) extends Expr("bool")
        case class I(int: Int) extends Expr("int")
        case class Sum(left: Expr, right: Expr) extends Expr("int")

        def eval(expr: Expr): Any = expr match {
            case B(b) => b
            case Or(left, right) => 
                if(left.tag != "bool" || right.tag != "bool") throw new Exception("Type error")
                else eval(left).asInstanceOf[Boolean] || eval(right).asInstanceOf[Boolean]
            case And(left, right) => //and me assert kerdiye hai
                eval(left).asInstanceOf[Boolean] || eval(right).asInstanceOf[Boolean]

            //same for other cases
            //still not type safe
            //still have to cast
            //still have to check the type
            //CHECK ANY--- REMOVE ANY
        }
        //this was tagging
    }



    }
}
