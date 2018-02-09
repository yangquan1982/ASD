Group 6
Members: Qu Yang, Yu Zhou, Huynh Truong

Source code distribution explaination:

1. Classes of GUI Navigation Framework:
INavigatorFactory
IPageFactory
APageNavigator
INavigatorState
APage
Override createPageA, createPageB and createNavigator methods of INavigatorFactory for page and navigator objects creation.
Override navigate method of APageNavigator and INavigatorState to implement real navigation.
Override open and navigate methods of APage to implement navigation details.

2. Classes of Membership Framework:
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

3. Classes of DataAccess Framework:
ConnectionPool,PoolConfigure, PoolBuilder,JDBCConnectionInfo
DaoAccess,DaoFactory,GenericDaoAccess
SQLConstructor,MappingObject
ColumnMetaData,TableMetaData,DataType
FacadeJDBCExecutor,FacadeJDBCProfiler

4. Classes of Recommendation Framework:
RateInformation
IRecomendation, CFRecommendation, CoOccurrenceRecommendation,RecommendtaionFactory
ISortMethod, HeapSort, OnePassCompareSort,SortType, SortUtil
ProductPurchasePredicate, PearsonCorrelationSimilarity, SimilarCustomers
ProducerConsumer
RecommendationService

AbstractMapper,Mapper,WordCountMapper, CoOccurenceMapper
Reducer
Pair,GoupbyPair
ComputeFrameWork





