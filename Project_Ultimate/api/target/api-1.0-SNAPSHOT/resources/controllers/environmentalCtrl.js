app.controller('environmentalCtrl', function ($scope, $http) {
    var chart;

    var i = 0;
    getEnvironmentals = function () {


        var data = {};
        // data.begin = date.begin;
        // data.end = date.end;

        $http.get("environmentalsbyid").then(function (response) {


            var data = response.data;
            var series = chart.series;

            data[i].t;
            data[i].rhw;
            data[i].p;
            data[i].l;
            data[i].n;
            data[i].time;
            chart.series[0].addPoint([data[i].time, data[i].t], true, 0);
            chart.series[1].addPoint([data[i].time, data[i].rhw], true, 0);
            //chart.series[2].addPoint([data[i].time, data[i].p], true, 0);
            chart.series[2].addPoint([data[i].time, data[i].l], true, 0);
            chart.series[3].addPoint([data[i].time, data[i].n], true, 0);

            i += 1;


            // }

            console.log(data);
        });
    }
    setInterval(getEnvironmentals, 100);


    var chart = new Highcharts.StockChart({
        chart: {
            plotOptions: {
                spline: {
                    dataGrouping: {
                        groupPixelWidth : 0
                    }
                }
            },
            plotBackgroundColor: '#ECF1F6',
            plotShadow: true,
            height: 800,
            width: 1300,
            //marginleft: 50,
            renderTo: 'container1',
            type: 'spline',
            zoomType: 'x',
            events: {
                load: getEnvironmentals
            },
            showCheckbox: true
        },
        legend: {
            enabled: true
        },
        rangeSelector: {

            buttons: [
                {
                    type: 'hour',
                    count: 1,
                    text: '1h'
                },
                {
                    type: 'minute',
                    count: 1,
                    text: '1m'
                }, {
                    type: 'second',
                    count: 1,
                    text: '1s'
                }, {
                    type: 'milisecond',
                    count: 1,
                    text: '1ms'
                }, {
                    type: 'all',
                    text: 'All'
                }],
            selected: 3
        },


        title: {
            text: 'Environmental data',
            style: {
                color: 'red',
                fontWeight: 'bold',

            }
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                milisecond: '%H:%M:%S.%L'
            },
            minRange: 1,
            useHighStocks: true,
            gridLineWidth: 1,
            title: {
                enabled: true,
                text: '<i>Loading data from server... ',
                style: {
                    fontWeight: 'normal'
                }
            }
        },
        yAxis: {
            title: {
                text: 'Value',
                //margin: 80
                gridLineWidth: 1,
            },
            minRange: 1
        },
        series: [{
            name: 't',
            data: [],
            dataGrouping: {
                enabled: false
            }

        }, {
            name: 'rhw',
            data: [],
            dataGrouping: {
                enabled: false
            }

        }, {
            name: 'l',
            data: [],
            dataGrouping: {
                enabled: false
            }

        } ,{
            name: 'n',
            data: [],
            dataGrouping: {
                enabled: false
            },
            showCheckbox: true

        }]

    });
    $scope.operationHighChartsData = chart;

});
