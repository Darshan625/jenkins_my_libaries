def call(String reportFile = 'report.html', String reportName = 'Trivy Security Report') {
    publishHTML(target: [
        allowMissing: false,
        alwaysLinkToLastBuild: true,
        keepAll: true,
        reportDir: '',        // current workspace
        reportFiles: reportFile,
        reportName: reportName
    ])
}
