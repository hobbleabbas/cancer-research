package conditionResearch

object MedicalConcept {
  class UMLS {

    val cid: String = ""

  }

  class Condition() extends UMLS

  class Drug() extends UMLS

}

case class Paper(author: String)