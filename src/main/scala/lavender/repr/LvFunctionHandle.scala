package lavender.repr

import lavender.FunctionName
import lavender.expr.LvExpression

sealed abstract class LvFunctionHandle {
  val arity: Int
  val name: FunctionName
}

object LvFunctionHandle {

  case class ByName(name: FunctionName, arity: Int) extends LvFunctionHandle

  case class ByCode(name: FunctionName, code: LvExpression, arity: Int, capture: IndexedSeq[LvExpression]) extends LvFunctionHandle

  case class ByNative(name: FunctionName, arity: Int, capture: IndexedSeq[LvExpression]) extends LvFunctionHandle

  def unapply(arg: LvFunctionHandle): Option[(FunctionName, Int)] = Some((arg.name, arg.arity))

}
