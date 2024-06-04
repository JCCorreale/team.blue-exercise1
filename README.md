# Quickstart

The solution is based on three main components:

- `reports.interfaces.ReportGenerator`: handles the generation of a traffic data report froma a request log
- `reports.interfaces.ReportPersister`: handles the persistence of traffic data reports serialized in a given format
- `reports.util.ReportMapper`: handles serialization of traffic data reports

Tests for `ReportGenerator` and `ReportPersister` implementations can be found in `src/test/java/reports/impl`.

Tests for `ReportMapper` implementations can be found `src/test/java/reports/util`

Models can be found in the `reports.model` package
