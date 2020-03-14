package Trait

trait BinarySearchTreeTrait {
  def getRoot(): NodeTrait
  def search(value: Int): NodeTrait
  def insert(value: Int): Boolean
  def searchAndRemove(value: Int): NodeTrait
}
