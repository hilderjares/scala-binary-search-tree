object Main extends App {
  println("* Binary Search Tree *")

  val tree: BinarySearchTree = new BinarySearchTree

  println(tree.insert(4))
  println(tree.insert(2))
  println(tree.insert(1))
  println(tree.insert(5))
  println(tree.insert(6))

  println(tree.search(1))
  println(tree.getRoot())
  println(tree.searchAndRemove(2))
  println(tree.searchAndRemove(4))

  tree.printTree()
}
