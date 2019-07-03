/* 
* add by axiang [20190703]
* 参照的旧数据库版本为2019年7月3日导出的OJInit.sql，新数据库的改动如下
*/

/* 对 contest 的修改 begin */
/* 对 contest 的修改 end */

/* 对 statu 的修改 begin */
ALTER table statu ADD INDEX indexResult(result);
ALTER table statu ADD INDEX indexLanguage(lang);
/* 对 statu 的修改 end */

/* 对 t_challenge_block 的修改 begin */
/* 对 t_challenge_block 的修改 end */


/* 对 t_challenge_condition 的修改 begin */
/* 对 t_challenge_condition 的修改 end */
 

/* 对 t_verify 的修改 begin */
/* 对 t_verify 的修改 end */