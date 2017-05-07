'use strict';

shareit.factory('bookData', function ($http) {
    return {
        postBook: function (book) {
        return $http({
            method: 'POST',
            url: 'shareit/media/books',
            data: book
        });
    }
    }
});