Classes of GUI Navigation Framework:
INavigatorFactory
IPageFactory
APageNavigator
INavigatorState
APage
Override createPageA, createPageB and createNavigator methods of INavigatorFactory for page and navigator objects creation.
Override navigate method of APageNavigator and INavigatorState to implement real navigation.
Override open and navigate methods of APage to implement navigation details.

Classes of Membership:
Member
IProxyFacade
IEncryption
IHashing
IValidate
ITemplateFacade
Override getHashString, verifyStringByHash, encryptString, decryptString, validateString of IProxyFacade
Override encryptString, decryptString of IEncryption
Override getHashString, verifyStringByHash of IHashing
Override validateString of IValidate
Override SignUp, login, updateProfile of ITemplateFacade