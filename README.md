# Distributed Commerce
## Authentication & Request Correctness

- APIs are designed to be idempotent to safely handle retries.
- Authorization is enforced at service boundaries to prevent privilege escalation.
- Critical operations validate request ownership before execution.
- Failure scenarios (partial writes, duplicate requests) are explicitly handled.

## Failure Handling & Trade-offs

- How the system behaves under duplicate requests
- What happens when downstream services are unavailable
- Data consistency guarantees and trade-offs chosen
- Retry and rollback strategies

