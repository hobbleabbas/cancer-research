/**
  * Defines common utils
  * Utils include:
        - ScienceIO: Helper wrapper for making scienceio calls
        - DBQueries: Helper methods to make queries to database, and restore schema at a given point
  */
object Utils {
  object ScienceIO extends App {
    val API_URL: String = "https://api.aws.science.io/v2"
    val HELP_EMAIL: String = "api_support@science.io"
    val DEFAULT_TIMEOUT: Int = 1200
    val MAX_POLL_DURATION_SEC: Int = 300
    val POLL_SLEEP_DURATION_SEC: Int = 2
    val MAX_CHARACTERS: Int = 10000

    sealed trait ScienceioInferenceStatus
    case object Submitted extends ScienceioInferenceStatus { val name = "SUBMITTED" }
    case object Completed extends ScienceioInferenceStatus { val name = "COMPLETED" }
    case object Errored extends ScienceioInferenceStatus { val name = "ERRORED" }

    sealed trait ScienceiOModelType
    case object Structure extends ScienceIOModelType { val name = "STRUCTURE" }
    case object Annotate extends ScienceIOModelType { val name = "ANNOTATE" }

    case class ScienceIOResponse(requestId: String, text: Option[String], inferenceStatus: ScienceioInferenceStatus, message: Option[String], spans: Option[Any], modelType: ScienceioModelType)

    class ScienceIOError(message: String = "Error in request to ScienceIO API") extends Error(message) {
        // Base class for all exceptions that are raised by the ScienceIO SDK.
        override def fillInStackTrace(): Throwable = this
    }

    class HTTPError(statusCode: Int, message: String = "HTTP Error in request to ScienceIO API") extends ScienceIOError(message) {
        // Exception raised when the ScienceIO API returns an HTTP error.
        override def fillInStackTrace(): Throwable = this
    }

    class TimeoutError(message: String = "Timeout in request to ScienceIO API") extends ScienceIOError(message) {
        // Exception raised when the ScienceIO API times out.
        override def fillInStackTrace(): Throwable = this
    }
    
    val status: ScienceioInferenceStatus = Completed
    
    status match {
        case Submitted => println("Inference was submitted.")
        case Completed => println("Inference has completed.")
        case Errored => println("Inference encountered an error.")
    }
    
  }

}
