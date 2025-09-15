def call(Map params = [:]) {

    // Git checkout
    if (params.git) {
        git branch: params.branch ?: 'master',
            credentialsId: params.credentialsId ?: 'wsltobitbucket',
            url: params.url ?: 'ssh://git@bitbucket.temenos.com:7999/tc/tbac-registry.git'
        echo "Git checkout done."
    }

    // Welcome message
    if (params.welcome) {
        echo "Hi ${params.name ?: 'Darshan'}, welcome to Jenkins shared library!"
        echo "Team: ${params.team ?: 'AI'}, Project: ${params.project ?: 'DevOps'}"
    }

    // Publish HTML report
    if (params.publish) {
        publishHTML(target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: params.reportDir ?: '',
            reportFiles: params.reportFile ?: 'report.html',
            reportName: params.reportName ?: 'HTML Report'
        ])
    }

    if (!params.git && !params.welcome && !params.publish) {
        error "Nothing to do. Pass at least one of: git, welcome, publish"
    }
}
