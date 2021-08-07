Older versions of this plugin may not be safe to use. Please review the following warnings before using an older version:

-   [Plugin globally disables SSL/TLS certification validation in Jenkins](https://jenkins.io/security/advisory/2018-06-25/#SECURITY-941)

The CollabNet Plugin is an integration with [CollabNet TeamForge](http://www.open.collab.net/products/sfee/ "CollabNet TeamForge").Don't
have TeamForge yet?  Try our [free 90-day trial](http://www.open.collab.net/products/sfee/tryit.html "free 30-day trial").

Provided features include:

-   Authenticate users from TeamForge.  If setup as the "Build & Test" application, it can even use Single Sign-On.
-   Authorization from TeamForge, including the ability to set permissions in Jenkins based on roles in your TeamForge project.
-   Upload the build log or workspace artifacts to the TeamForge Documents.
-   Upload workspace artifacts to the TeamForge File Release System, as a post-build publishing task or as a build promotion task.
-   Open/update/close TeamForge Tracker artifacts based on the Jenkins build status.
-   Upload workspace artifacts to the Lab Management Project Build Library.  (Requires [CollabNet Lab Management](http://www.open.collab.net/products/CUBiT/ "CollabNet Lab Management")).

# Requirements:

The CollabNet Plugin requires the [Promoted Builds Plugin](https://wiki.jenkins.io/display/JENKINS/Promoted+Builds+Plugin).

The CollabNet Plugin requires the [Subversion Plugin](https://wiki.jenkins.io/display/JENKINS/Subversion+Plugin).

The CollabNet Plugin requires a [CollabNet TeamForge 5.2](http://www.open.collab.net/products/sfee/ "CollabNet TeamForge 5.2")+ or [CollabNet SourceForge 5.0](http://www.open.collab.net/products/sfee/ "CollabNet SourceForge 5.0")+ server.  The Authorization component will only work with CollabNet TeamForge 5.2 or later.

The Lab Management PBL Upload component requires a [CollabNet Lab Management](http://www.open.collab.net/products/CUBiT/ "CollabNet Lab Management") server.  But don't worry, all the other components will work just fine without it.

# Configuring Components:

Following individual component can be configured within each Jenkins job

## [Authentication](https://github.com/jenkinsci/collabnet-plugin/blob/master/docs/AUTHENTICATION.md)

## [Document Uploader](https://github.com/jenkinsci/collabnet-plugin/blob/master/docs/DOCUMENTS.md)

## [File Release to TeamForge](https://github.com/jenkinsci/collabnet-plugin/blob/master/docs/FRS.md)

## [Project Build Library](https://github.com/jenkinsci/collabnet-plugin/blob/master/docs/PBL.md)

## [Tracker](https://github.com/jenkinsci/collabnet-plugin/blob/master/docs/TRACKER.md)

## [SCMViewer for Subversion](https://github.com/jenkinsci/collabnet-plugin/blob/master/docs/SCM.md)

# Help/Support:

Please submit any questions to the [TeamForge forum](http://forums.open.collab.net/ds/viewForumSummary.do?dsForumId=736 "TeamForge forum").

# FAQ:

   1.  Does this integrate with / update the [SFEE Plugin](https://wiki.jenkins.io/display/JENKINS/SFEE+Plugin)?

        No, the [SFEE Plugin](https://wiki.jenkins.io/display/JENKINS/SFEE+Plugin) is a separate plugin that is not maintained by [CollabNet](http://www.collab.net/ "CollabNet").  It works with CollabNet SourceForge 4.4, so it may be a good choice if you have an older version.  Our plugin is not a direct upgrade.  If you change from using the [SFEE Plugin](https://wiki.jenkins.io/display/JENKINS/SFEE+Plugin) to the CollabNet Plugin, you will have to reconfigure your jobs appropriately. You should be able to use both plugins simultaneously, if you wish, although it might be a bit confusing.

   2.  Uploads fail when using an SSL-enabled TeamForge server.  What do I do?

        You'll need to add the server's certificate to your java keystore on the Jenkins server.  First dowload the certificate to your Jenkins server.  You should be able to get it by opening a browser window on the TeamForge server, viewing the certificate associated with that page, and exporting the certificate file.  Then, you'll need to run something like "sudo keytool -keystore $JAVA\_HOME/jre/lib/security/cacerts -import -file teamforge.cert".  (On Windows, replace $JAVA\_HOME with %JAVA\_HOME%).  If you haven't changed your java keystore's password, it will be "changeit".  After you've imported the cert to the java instance that Jenkins is using, it should be able to upload.

   3.  I'm having problems with login and logout when using CollabNet Authentication.  It seems to be redirecting to an unexpected site.

        Go to the Jenkins configure page and look in the Email Notifacation section. The CollabNet plugin uses the value of the Jenkins URL set here for redirection. If it's wrong, logins will go astray. Check that it's set to the real Jenkins URL. 

   4.  I've setup authentication, but can no longer get to the "Manage Jenkins" pages.&nbps; How do I get back into the system?

        As long as you have access to the machine and user running Jenkins, you'll be able to get back in. Just log into the machine. Find the Jenkins home (by default, this will be the \~/.jenkins or \~/.hudson directory of the user running Jenkins). Edit the config.xml, changing the value for "useSecurity" to false. Restart Jenkins and you should not need to log in to get access.

# Running Tests

There are some tests that require a live CTF instance. If you do not have a CTF instance, you can skip those tests by running Maven with the "-Doffline" option.

Otherwise, you need the "~/.teamforge" property file that contains information about how to access the CTF instance.

This file has to contain the following 4 information:

```
teamforge_url=https://test.example.org/
admin_user=admin
password=****
teamforge_project=hudson-test
```

The user has to have a full access on the specified CTF instance. The test involves messing around with the specified project, so you'd better specify the project whose contents is not important.

## More information

* [Changelog](https://github.com/jenkinsci/collabnet-plugin/blob/master/CHANGELOG.md)
