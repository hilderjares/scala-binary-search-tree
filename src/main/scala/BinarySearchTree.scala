import Trait.{BinarySearchTreeTrait, NodeTrait}

class BinarySearchTree extends BinarySearchTreeTrait {
  private var _rootNode: NodeTrait = null

  override def getRoot(): NodeTrait = {
    _rootNode
  }

  private def isEmpty(node: NodeTrait): Boolean = {
    if (node == null) true else false
  }

  override def search(value: Int): NodeTrait = {
    val node: NodeTrait = searchRecursive(_rootNode, value)
    node
  }

  private def searchRecursive(node: NodeTrait, value: Int): NodeTrait = {
    if (isEmpty(node)) return null
    if (value == node.getValue()) return node

    if (value <= node.getValue()) {
      searchRecursive(node.getLeftChild(), value)
    } else {
      searchRecursive(node.getRightChild(), value)
    }
  }

  override def insert(value: Int): Boolean = {
    _rootNode = addRecursive(_rootNode, value)

    if (!isEmpty(_rootNode)) true else false
  }

  private def addRecursive(node: NodeTrait, value: Int): NodeTrait = {
    if (isEmpty(node)) {
      val newNode = new Node
      newNode.value_=(value)
      return newNode
    }

    if (!isEmpty(node) && value <= node.getValue()) {
      node.leftChild_=(addRecursive(node.getLeftChild(), value))
    }

    if (!isEmpty(node) && value > node.getValue()) {
      node.rightChild_=(addRecursive(node.getRightChild(), value))
    }

    node
  }

  override def searchAndRemove(value: Int): NodeTrait = {
    removeRecursion(_rootNode, value)
  }

  private def removeRecursion(node: NodeTrait, value: Int): NodeTrait = {
    if (isEmpty(node)) {
      return node
    }

    if (value < node.getValue()) {
      node.leftChild_=(removeRecursion(node.getLeftChild(), value))
    } else if (value > node.getValue()) {
      node.rightChild_=(removeRecursion(node.getRightChild(), value))
    } else {
      if (isEmpty(node.getLeftChild()) && isEmpty(node.getRightChild())) {
        return null
      }

      if (isEmpty(node.getRightChild())) {
        return node.getLeftChild()
      }

      if (isEmpty(node.getLeftChild())) {
        return node.getRightChild()
      }

      val smallest: Int = findSmallestValue(node.getRightChild())
      node.value_=(smallest)
      node.rightChild_=(removeRecursion(node.getRightChild(), value))
    }

    node
  }

  private def findSmallestValue(node: NodeTrait): Int = {
    if (!isEmpty(node.getLeftChild())) {
      return findSmallestValue(node.getLeftChild())
    }
    node.getValue()
  }

  private def traversePreOrder(node: NodeTrait): Unit = {
    if (!isEmpty(node)) {
      println(node.getValue())
      traversePreOrder(node.getLeftChild())
      traversePreOrder(node.getRightChild())
    }
  }

  def printTree(): Unit = {
    traversePreOrder(_rootNode)
  }
}
