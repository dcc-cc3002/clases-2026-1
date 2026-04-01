package clase06

trait Tree:
  def sum(): Int
  def min(): Int
  def max(): Int

class Node(val value: Int, val left: Tree, val right: Tree) extends Tree:
  def sum(): Int = value + left.sum() + right.sum()
  def min(): Int = Math.min(value, Math.min(left.min(), right.min()))
  def max(): Int = Math.max(value, Math.max(left.max(), right.max()))

class Leaf(val value: Int) extends Tree:
  def sum(): Int = value
  def min(): Int = value
  def max(): Int = value

class NullTree() extends Tree:
  def sum(): Int = 0
  def min(): Int = Integer.MAX_VALUE
  def max(): Int = Integer.MIN_VALUE
