error id: file:///C:/Projects/Algebras-and-TaglessFinals/src/main/scala/TaglessFinal.scala:[4479..4480) in Input.VirtualFile("file:///C:/Projects/Algebras-and-TaglessFinals/src/main/scala/TaglessFinal.scala", "import scala.quoted.Expr

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
    //but we still dont have type safety and errors at runtime
    object Tagless {
        trait Expr[A]
        case class B(boolean: Boolean) extends Expr[Boolean]
        case class Or(left: Expr[Boolean], right: Expr[Boolean]) extends Expr[Boolean]
        case class And(left: Expr[Boolean], right: Expr[Boolean]) extends Expr[Boolean]
        case class Not(expr: Expr[Boolean]) extends Expr[Boolean]
        case class I(int: Int) extends Expr[Int]
        case class Sum(left: Expr[Int], right: Expr[Int]) extends Expr[Int]
        //we are using type parameters to make sure that the type is correct
        //type arguments are the types that we pass to the type parameters

        def eval[A](expr: Expr[A]): A = expr match {
            case B(b) => b
            case Or(left, right) => eval(left) || eval(right)
            case And(left, right) => eval(left) && eval(right)
            case Not(expr) => !eval(expr)
            case I(i) => i
            case Sum(left, right) => eval(left) + eval(right)
        }
        //we are returning the correct type for the correct expression
    }

    //this was taglesss solution
    //using generics to make sure that the type is correct
    object TaglessFinal{
        trait Expr[A]{
            val value: A
        }

        def b(b: Boolean): Expr[Boolean] = new Expr[Boolean]{
            val value = b
        }
        def or(left: Expr[Boolean], right: Expr[Boolean]): Expr[Boolean] = new Expr[Boolean]{
            val value = left.value || right.value
        }

        def eval[A](expr: Expr[A]): A = expr.value
    }

    def demoTagless(): Unit = {
        import Tagless._
        println(eval(Or(B(true), And(B(false), B(true)))))
        println(eval(Sum(I(2), I(3))))
        //correctness is proved at compile time

    }
    def 
}
}
")
file:///C:/Projects/Algebras-and-TaglessFinals/src/main/scala/TaglessFinal.scala
file:///C:/Projects/Algebras-and-TaglessFinals/src/main/scala/TaglessFinal.scala:119: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace