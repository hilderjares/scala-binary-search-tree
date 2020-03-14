package Trait

trait NodeTrait {
  def value_=(value: Int): Unit
  def getValue(): Int

  def leftChild_=(left: NodeTrait): Unit
  def getLeftChild(): NodeTrait

  def rightChild_=(right: NodeTrait): Unit
  def getRightChild(): NodeTrait
}
