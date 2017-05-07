'use strict';

shareit.factory('discData', function($http) {
   return {
       postDisc: function(disc) {
           return $http({
               method: 'POST',
               url: 'shareit/media/discs',
               data: disc
           });
       }
   }
});
