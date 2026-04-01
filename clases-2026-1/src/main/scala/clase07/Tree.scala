package clase07

trait Tree extends Comparable[Tree]:
  def sum(): Int
  def min(): Int
  def max(): Int

abstract class AbstractTree extends Tree:
  def compareTo(other: Tree): Int =
    if (sum() > other.sum()) 1
    else if (sum() < other.sum()) -1
    else 0

class Node(val value: Int, val left: Tree, val right: Tree)
    extends AbstractTree:
  def sum(): Int = value + left.sum() + right.sum()
  def min(): Int = Math.min(value, Math.min(left.min(), right.min()))
  def max(): Int = Math.max(value, Math.max(left.max(), right.max()))
  override def toString(): String = s"Node(${value}, ${left}, ${right})"

class Leaf(val value: Int) extends AbstractTree:
  def sum(): Int = value
  def min(): Int = value
  def max(): Int = value
  override def toString(): String = s"Leaf(${value})"

class NullTree() extends AbstractTree:
  def sum(): Int = 0
  def min(): Int = Integer.MAX_VALUE
  def max(): Int = Integer.MIN_VALUE
  override def toString(): String = s"Null"
