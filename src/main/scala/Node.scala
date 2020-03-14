import Trait.NodeTrait

class Node extends NodeTrait {
  private var _value: Int = 0
  private var _left: NodeTrait = null
  private var _right: NodeTrait = null

  override def value_=(newValue: Int): Unit = _value = newValue
  override def getValue(): Int = _value

  override def leftChild_=(left: NodeTrait): Unit = _left = left
  override def getLeftChild(): NodeTrait = _left

  override def rightChild_=(right: NodeTrait): Unit = _right = right
  override def getRightChild(): NodeTrait = _right
}
