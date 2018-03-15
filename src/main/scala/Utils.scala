class Utils {

  def  validateMinOccurrence(minOccurrence: Option[Int]) = {
    /*
     * Check whether minimum occurence is non-negative
    */
    minOccurrence match {
      case Some(v) if v < 0 => throw new Exception(s"Invalid minOccurrence supplied $minOccurrence")
      case _ => minOccurrence
    }
  }

}
